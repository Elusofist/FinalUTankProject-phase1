package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JPanel {
    static final int WIDTH = 800, HEIGHT = 800;
    int WIN_POINT;
    private final static int MINE_INTERVAL = 500, LASER_INTERVAL = 1000;
    static int time;

    List<Thing> everything = new ArrayList();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList();
    List<PowerUp> powerUps = new ArrayList<>();
    List<Mine> mines = new ArrayList<>();
    List<Laser> lasers = new ArrayList<>();
    ScoreBoard scoreBoard = new ScoreBoard(Game.WIDTH / 2 - 20, Game.HEIGHT - 40);

    boolean prevP1Fire = false, prevP2Fire = false, p1Won = false, p2Won = false;
    Map map;

    Game() {
        time = 0;
        map         = Data.getInstance().getMap();
        WIN_POINT   = Data.getInstance().getRoundToWin();

        this.setSize(WIDTH, HEIGHT);
        this.player1.newRound(false, Math.random() * WIDTH, Math.random() * HEIGHT);
        this.player2.newRound(false, Math.random() * WIDTH, Math.random() * HEIGHT);
        firstlyModifyRandomTank(this.player1.getTank(), this.player2.getTank());
        this.everything.add(this.player1.getTank());
        this.everything.add(this.player2.getTank());

        scoreBoard.setP1Point(player1.point);
        scoreBoard.setP2Point(player2.point);
        everything.add(scoreBoard);

        JButton akbar = new JButton("Menu");
        akbar.setBounds(200,100,300,300);
        akbar.setVisible(true);
        this.add(akbar);

        akbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Window.getInstance().game.setVisible(false);

                Window.getInstance().mainMenu.setVisible(true);

            }

        });

    }

    void modifyRandomTank(Tank lostTank, Tank wonTank) {
        boolean result;
        do {
            lostTank.x = (int) (WIDTH * Math.random());
            lostTank.y = (int) (HEIGHT * Math.random());
            result = lostTank.contacts(wonTank);
            for (Wall wall : map.getWalls()) {
                result = wall.contacts(lostTank);
                if (result)
                    break;
            }
        } while (result);
    }

    void firstlyModifyRandomTank(Tank p1Tank, Tank p2Tank) {
        boolean result;
        do {
            p1Tank.x = (int) (WIDTH * Math.random());
            p1Tank.y = (int) (HEIGHT * Math.random());
            p2Tank.x = (int) (WIDTH * Math.random());
            p2Tank.y = (int) (HEIGHT * Math.random());
            result = p1Tank.contacts(p2Tank);
            for (Wall wall : map.getWalls()) {
                result = wall.contacts(p1Tank) || wall.contacts(p2Tank);
                if (result)
                    break;
            }
        } while (result);
    }

    void listenedActionHandler(GameActionListener listener, Tank p1Tank, Tank p2Tank) {
        if (listener.p1Move) {
            p1Tank.changeVelocity();
//            p1Tank.step();
//            if (p1Tank.contacts(p2Tank)
//                    || map.getWalls().stream().anyMatch(w -> w.contacts(p1Tank))) {
//                p1Tank.addPIToDirection();
//                p1Tank.step();
//                p1Tank.addPIToDirection();
//            }
        }

        if (listener.p1Left) {
            p1Tank.turnLeft();
        }

        if (listener.p1Right) {
            p1Tank.turnRight();
        }

        if (listener.p1Down) {
            p1Tank.changeVelocity();
            p1Tank.addPIToDirection();
//            p1Tank.step();
//            if (p1Tank.contacts(p2Tank)
//                    || map.getWalls().stream().anyMatch(w -> w.contacts(p1Tank))) {
//                p1Tank.changeVelocity();
//                p1Tank.addPIToDirection();
//                p1Tank.step();
//                p1Tank.addPIToDirection();
//            }
        }

        if (listener.p1Fire) {
            if (p1Tank.powerUpShape == null) {
                if (player1.ammo > 0) {
                    if (!prevP1Fire) {
                        Shot s = new Shot(p1Tank.getGunX(), p1Tank.getGunY(), p1Tank.getDirection());
                        this.shotsInTheAir.add(s);
                        player1.ammo--;
                    }
                }
            }
            else {
                if (p1Tank.powerUpShape instanceof MineShape){
                    if (!prevP1Fire) {
                        Mine mine = new Mine(p1Tank.getX(), p1Tank.getY(), p2Tank);
                        mines.add(mine); // maybe not needed.
                        p1Tank.powerUpShape = null;
                    }
                }
                else if (p1Tank.powerUpShape instanceof LaserShape){
                    p1Tank.laser.isEmitting = true;
                }
            }
        }
        else {
            if (p1Tank.powerUpShape != null){
                if (p1Tank.powerUpShape instanceof LaserShape){
                    p1Tank.laser.isEmitting = false;
                }
            }
        }
        prevP1Fire = listener.p1Fire;

        if (listener.p2Move) {
            p2Tank.changeVelocity();
//            p2Tank.step();
//
        }

        if (listener.p2Left) {
            p2Tank.turnLeft();
        }

        if (listener.p2Right) {
            p2Tank.turnRight();
        }

        if (listener.p2Down) {
            p2Tank.changeVelocity();
            p1Tank.addPIToDirection();
//            p1Tank.step();
//
        }

        if(!listener.p1Move && !listener.p1Down) p1Tank.changeNegVelocity();
        if(!listener.p2Down && !listener.p2Move) p2Tank.changeNegVelocity();

        if (listener.p2Fire) {
            if (p2Tank.powerUpShape == null) {
                if (player2.ammo > 0) {
                    if (!prevP2Fire) {
                        Shot s = new Shot(p2Tank.getGunX(), p2Tank.getGunY(), p2Tank.getDirection());
                        this.shotsInTheAir.add(s);
                        player2.ammo--;
                    }
                }
            }
            else {
                if (p2Tank.powerUpShape instanceof MineShape){
                    if (!prevP2Fire) {
                        Mine mine = new Mine(p2Tank.getX(), p2Tank.getY(), p1Tank);
                        mines.add(mine); // maybe not needed.
                        p2Tank.powerUpShape = null;
                    }
                }
                else if (p2Tank.powerUpShape instanceof LaserShape){
                    p2Tank.laser.isEmitting = true;
                }
            }
        }
        else {
            if (p2Tank.powerUpShape != null){
                if (p2Tank.powerUpShape instanceof LaserShape){
                    p2Tank.laser.isEmitting = false;
                }
            }
        }
        prevP2Fire = listener.p2Fire;

        if (time != 0) {
            p1Tank.step();
            p2Tank.step();
        }

        if (p1Tank.contacts(p2Tank)
                || map.getWalls().stream().anyMatch(w -> w.contacts(p2Tank))) {
            p2Tank.changeVelocity();
            p2Tank.addPIToDirection();
            p2Tank.step();
            p2Tank.addPIToDirection();
        }

        if (p2Tank.contacts(p1Tank)
                || map.getWalls().stream().anyMatch(w -> w.contacts(p2Tank))) {
            p2Tank.changeNegVelocity();
            p1Tank.addPIToDirection();
            p1Tank.step();
            p1Tank.addPIToDirection();
        }
    }

    void movingAndContactHandler(Tank p1Tank, Tank p2Tank) {
        for (Shot shot : shotsInTheAir) {
            for (Wall wall : map.getWalls()) {
                if (wall.contacts(shot))
                    shot.bounceAgainst(wall);
                else
                    shot.step();
            }
            if (p1Tank.contacts(shot)) {
                shot.kill();
                this.everything.remove(this.player1.getTank());
                this.modifyRandomTank(p1Tank, p2Tank);
                this.player1.newRound(false, (double) p1Tank.x, (double) p1Tank.y);
                this.everything.add(this.player1.getTank());
                this.player2.newRound(true, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
            }

            if (p2Tank.contacts(shot)) {
                shot.kill();
                this.everything.remove(this.player2.getTank());
                this.modifyRandomTank(p2Tank, p1Tank);
                this.player2.newRound(false, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
                this.everything.add(this.player2.getTank());
                this.player1.newRound(true, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
            }
        }

        for (Mine mine: mines){
            if (p2Tank.contacts(mine)){
                if (mine.foe.equals(p2Tank)) {
                    mine.kill(); // kill this shot!
                    everything.remove(player2.getTank());
                    modifyRandomTank(p2Tank, p1Tank);
                    player2.newRound(false, p2Tank.x, p2Tank.y);
                    everything.add(player2.getTank());

                    player1.newRound(true, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
                }
            }

            if (p1Tank.contacts(mine)){
                if (mine.foe.equals(p1Tank)) {
                    mine.kill(); // kill this shot!
                    everything.remove(player1.getTank());
                    modifyRandomTank(p1Tank, p2Tank);
                    player1.newRound(false, p1Tank.x, p1Tank.y);
                    everything.add(player1.getTank());

                    player2.newRound(true, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
                }
            }
        }

        this.shotsInTheAir.forEach(Shot::growOld);
        this.powerUps.forEach(PowerUp::growOld);
        this.mines.forEach(Mine::growOld);
        this.lasers.forEach(Laser::update);
        this.lasers.forEach(Laser::growOld);

        for (Laser laser: lasers) {
            if (laser.age <= 0)
                (laser.owner).powerUpShape = null;
        }

        this.shotsInTheAir.removeIf(Shot::isDead);
        this.powerUps.removeIf(PowerUp::isDead);
        this.mines.removeIf(Mine::isDead);
        this.lasers.removeIf(Laser::isDead);

        powerUpsEmerges();

        for (PowerUp powerUpShape : powerUps) {
            if (p1Tank.contacts(powerUpShape)) {
                p1Tank.setPowerUp(powerUpShape);
                if (powerUpShape instanceof LaserShape) {
                    Laser laser = new Laser(p1Tank.getGunX(), p1Tank.getGunY(), p1Tank);
                    p1Tank.laser = laser;
                    lasers.add(laser);
                }
                powerUpShape.kill();
            }

            if (p2Tank.contacts(powerUpShape)) {
                p2Tank.setPowerUp(powerUpShape);
                if (powerUpShape instanceof LaserShape) {
                    Laser laser = new Laser(p2Tank.getGunX(), p2Tank.getGunY(), p2Tank);
                    p2Tank.laser = laser;
                    lasers.add(laser);
                }
                powerUpShape.kill();
            }
        }

//        for (Laser laser: lasers){
//            if (laser.isEmitting) {
//                System.out.println(p2Tank.contacts(laser));
//            }
//        }
    }

    void powerUpsEmerges() {
        if (time % MINE_INTERVAL == 0){
            powerUps.add(new MineShape((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT)));
        }
        if (time % LASER_INTERVAL == 0) {
            powerUps.add(new LaserShape((int) (Math.random()*Game.WIDTH), (int) (Math.random()*Game.HEIGHT)));
        }
    }

    void ammoFinish() {
        if (this.player1.ammo <= 0 && this.player2.ammo <= 0) {
            this.everything.remove(this.player2.getTank());
            this.player2.newRound(false, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
            this.everything.add(this.player2.getTank());
            this.everything.remove(this.player1.getTank());
            this.player1.newRound(false, Math.random() * Game.WIDTH, Math.random() * Game.HEIGHT);
            this.everything.add(this.player1.getTank());
        }
    }

    void updateState() {
        if (this.player1.point < WIN_POINT && this.player2.point < WIN_POINT) {
            Tank p1Tank = this.player1.getTank();
            Tank p2Tank = this.player2.getTank();
            scoreBoard.setP2Point(player2.point);
            scoreBoard.setP1Point(player1.point);

            movingAndContactHandler(p1Tank, p2Tank);

            GameActionListener listener = (GameActionListener)this.getKeyListeners()[0];

            listenedActionHandler(listener, p1Tank, p2Tank);

            ammoFinish();

        } else if (this.player1.point == WIN_POINT) {
            this.everything = new ArrayList<>();
            this.shotsInTheAir = new ArrayList<>();
            this.powerUps = new ArrayList<>();
            this.p1Won = true;
        } else if (this.player2.point == WIN_POINT) {
            this.everything = new ArrayList<>();
            this.shotsInTheAir = new ArrayList<>();
            this.powerUps = new ArrayList<>();
            this.p2Won = true;
        }
        time++;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        if (this.p1Won) {
            graphics.drawString("Player 1 won!", Game.WIDTH / 2 - 20, Game.HEIGHT / 2);
        }

        else if (this.p2Won) {
            graphics.drawString("Player 2 won!", Game.WIDTH / 2 - 20, Game.HEIGHT / 2);
        }
        else
            map.draw(graphics);

        this.mines.forEach((mine -> mine.draw(graphics)));
        this.everything.forEach((thing) -> thing.draw(graphics));
        this.shotsInTheAir.forEach((shot) -> shot.draw(graphics));
        this.powerUps.forEach((powerUp -> powerUp.draw(graphics)));
        this.lasers.forEach((laser -> laser.draw(graphics)));


        Toolkit.getDefaultToolkit().sync();
    }
}