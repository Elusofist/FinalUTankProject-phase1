package com.company;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;

public class Game extends JFrame {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int WIN_POINT = 2;
    List<Thing> everything = new ArrayList();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList();
    boolean prevP1Fire = false;
    boolean prevP2Fire = false;
    boolean p1Won = false;
    boolean p2Won = false;

    Game() {
        this.setSize(WIDTH, HEIGHT);
        this.player1.newRound(false, Math.random() * WIDTH, Math.random() * HEIGHT);
        this.player2.newRound(false, Math.random() * WIDTH, Math.random() * HEIGHT);
        this.modifyRandomTank(this.player1.getTank(), this.player2.getTank());
        this.everything.add(this.player1.getTank());
        this.everything.add(this.player2.getTank());
    }

    void modifyRandomTank(Tank lostTank, Tank wonTank) {
        do {
            lostTank.x = (int)(WIDTH * Math.random());
            lostTank.y = (int)(HEIGHT * Math.random());
        } while(lostTank.contacts(wonTank));
    }

    void movingHandler(GameActionListener listener, Tank p1Tank, Tank p2Tank) {
        if (listener.p1Move) {
            p1Tank.step();
            if (p1Tank.contacts(p2Tank)) {
                p1Tank.negStep();
            }
        }

        if (listener.p1Left) {
            p1Tank.turnLeft();
        }

        if (listener.p1Right) {
            p1Tank.turnRight();
        }

        if (listener.p1Down) {
            p1Tank.negStep();
            if (p1Tank.contacts(p2Tank)) {
                p1Tank.step();
            }
        }

        if (listener.p1Fire && !this.prevP1Fire && this.player1.ammo > 0) {
            this.shotsInTheAir.add(new Shot(p1Tank.getGunX(), p1Tank.getGunY(), p1Tank.getDirection()));
            --this.player1.ammo;
        }

        this.prevP1Fire = listener.p1Fire;
        if (listener.p2Move) {
            p2Tank.step();
            if (p1Tank.contacts(p2Tank)) {
                p2Tank.negStep();
            }
        }

        if (listener.p2Left) {
            p2Tank.turnLeft();
        }

        if (listener.p2Right) {
            p2Tank.turnRight();
        }

        if (listener.p2Down) {
            p2Tank.negStep();
            if (p1Tank.contacts(p2Tank)) {
                p2Tank.step();
            }
        }

        if (listener.p2Fire && !this.prevP2Fire && this.player2.ammo > 0) {
            this.shotsInTheAir.add(new Shot(p2Tank.getGunX(), p2Tank.getGunY(), p2Tank.getDirection()));
            --this.player2.ammo;
        }
        this.prevP2Fire = listener.p2Fire;
    }

    void contactHandler(Tank p1Tank, Tank p2Tank) {
        for (Shot shot : shotsInTheAir) {
            if (p1Tank.contacts(shot)) {
                shot.kill();
                this.everything.remove(this.player1.getTank());
                this.modifyRandomTank(p1Tank, p2Tank);
                this.player1.newRound(false, (double)p1Tank.x, (double)p1Tank.y);
                this.everything.add(this.player1.getTank());
                this.player2.newRound(true, Math.random() * 700.0D, Math.random() * 700.0D);
            }

            if (p2Tank.contacts(shot)) {
                shot.kill();
                this.everything.remove(this.player2.getTank());
                this.modifyRandomTank(p2Tank, p1Tank);
                this.player2.newRound(false, Math.random() * 700.0D, Math.random() * 700.0D);
                this.everything.add(this.player2.getTank());
                this.player1.newRound(true, Math.random() * 700.0D, Math.random() * 700.0D);
            }
        }
    }

    void ammoFinish() {
        if (this.player1.ammo <= 0 && this.player2.ammo <= 0) {
            this.everything.remove(this.player2.getTank());
            this.player2.newRound(false, Math.random() * 700.0D, Math.random() * 700.0D);
            this.everything.add(this.player2.getTank());
            this.everything.remove(this.player1.getTank());
            this.player1.newRound(false, Math.random() * 700.0D, Math.random() * 700.0D);
            this.everything.add(this.player1.getTank());
        }
    }

    void updateState() {
        if (this.player1.point < WIN_POINT && this.player2.point < WIN_POINT) {
            Tank p1Tank = this.player1.getTank();
            Tank p2Tank = this.player2.getTank();

            for (Shot shot : this.shotsInTheAir) {
                shot.step();
            }

            this.shotsInTheAir.forEach(Shot::growOld);
            this.shotsInTheAir.removeIf(Shot::isDead);
            GameActionListener listener = (GameActionListener)this.getKeyListeners()[0];

            movingHandler(listener, p1Tank, p2Tank);

            contactHandler(p1Tank, p2Tank);

            ammoFinish();

        } else if (this.player1.point == WIN_POINT) {
            this.everything = new ArrayList<>();
            this.shotsInTheAir = new ArrayList<>();
            this.p1Won = true;
        } else if (this.player2.point == WIN_POINT) {
            this.everything = new ArrayList<>();
            this.shotsInTheAir = new ArrayList<>();
            this.p2Won = true;
        }

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.everything.forEach((thing) -> thing.draw(graphics));
        this.shotsInTheAir.forEach((shot) -> shot.draw(graphics));
        graphics.drawString(this.player1.point + " - " + this.player2.point, 350, 680);

        if (this.p1Won) {
            graphics.drawString("Player 1 won!", 320, 360);
        }

        if (this.p2Won) {
            graphics.drawString("Player 2 won!", 320, 360);
        }

        Toolkit.getDefaultToolkit().sync();
    }
}
