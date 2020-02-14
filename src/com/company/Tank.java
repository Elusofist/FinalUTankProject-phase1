package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.*;

public class Tank extends MovingThing {
    static int RADIUS = 25;
    final static int GUN_LENGTH = 40, GLOWING_INTERVAL = 20;
    PowerUp powerUpShape = null;
    Laser laser = null;
    SimpleAudioPlayer laserSound;

    Tank(int x, int y, double d) {
        super(x, y, d, 0.06f, 0);
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUpShape = powerUp;
    }

    void draw(Graphics graphic) {
        if (this.powerUpShape != null) {// should be glowing
            if (this.powerUpShape instanceof MineShape){
            // inja if bezarim ke age mine bood chejoori, age laser bood chejoori
             graphic.setColor(new Color((int) (128 + Math.cos(Game.time * Math.PI / GLOWING_INTERVAL) * 120), 0, 0));
        } else if (this.powerUpShape instanceof LaserShape) {
            graphic.setColor(new Color((int) (128 + Math.cos(Game.time * Math.PI / GLOWING_INTERVAL) * 120), 0,255));
            }
        } else
            graphic.setColor(new Color(82, 105, 135));

        graphic.fillOval(
                this.x - this.RADIUS,
                this.y - this.RADIUS,
                this.RADIUS * 2,
                this.RADIUS * 2
        );
        Graphics2D g2 = (Graphics2D) graphic;
        g2.setStroke(new BasicStroke(6));
        g2.drawLine(this.x, this.y, this.getGunX(), this.getGunY());
    }

    boolean gunContacts(Tank foe) {
        int x1 = Math.max(this.getGunX(), this.getX());
        int y1 = Math.max(this.getGunY(), this.getY());
        int x2 = Math.min(this.getGunX(), this.getX());
        int y2 = Math.min(this.getGunY(), this.getY());

        if (foe.getGunX() >= x2 && foe.getGunX() <= x1 && foe.getGunY() >= y2 && foe.getGunY() <= y2) {

            if (((this.getGunX() - this.getX())) != 0) {
                return foe.getGunY() - this.getGunY() == ((this.getGunY() - this.getY()) / (this.getGunX() - this.getX())) * (foe.getGunX() - this.getGunX());
            } else {
                return foe.getGunX() == this.getGunX();
            }
        }

        return false;
    }

    boolean contacts(Thing thing) {
        boolean result = false;
        double distance = Math.sqrt(Math.pow((this.x - thing.getX()), 2.0D) + Math.pow((this.getY() - thing.getY()), 2.0D));
        int sum = this.RADIUS;
        if (thing instanceof Shot) {
            sum += Shot.RADIUS;
            result = distance <= sum;
        }

        if (thing instanceof Tank) {
            sum += this.RADIUS;
            result = gunContacts((Tank) thing) || distance <= sum;
        }

        if (thing instanceof PowerUp) {
            sum += Mine.RADIUS;
            result = distance <= sum;
        }

        if (thing instanceof Mine) {
            sum += Mine.RADIUS;
            result = distance <= sum;
        }

//        if (thing instanceof Laser) {
//            Laser laser = (Laser) thing;
//            distance = laser.contacts(this.getX(), this.getY());
//            result = distance <= sum;
//        }

        if (thing instanceof Laser){
            Laser laser = (Laser) thing;
            Tank tank = laser.owner;
            double m, b; // baraye moadele xat
            m = ((-1 / Math.tan(tank.getDirection())) * tank.getGunX() + tank.getGunY());
            b = tank.getGunY() - m * tank.getGunX();

            if (tank.getY() > tank.getGunY())
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS )
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS );

            if (tank.getX() > tank.getGunX() && tank.getY() < tank.getGunY())
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS )
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS );

            if (tank.getX() < tank.getGunX() && tank.getY() < tank.getGunY())
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS )
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS );


            if (tank.getX() == tank.getGunX() && tank.getY() > tank.getGunY()){
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS )
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS );
            }


            if (tank.getX() == tank.getGunX() && tank.getY() < tank.getGunY())
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS )
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS );


            if (tank.getX() > tank.getGunX() && tank.getY() == tank.getGunY()) {
                m = 0;
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS)
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS);
            }

            if (tank.getX() < tank.getGunX() && tank.getY() == tank.getGunY()) {
                m = 0;
                result = (laser.y < (m * laser.x) + b + Tank.RADIUS)
                        && (laser.y > (m * laser.x) + b - Tank.RADIUS);
            }
        }


        if (thing instanceof FragBomb) {
            sum += FragBomb.RADIUS;
            result = distance <= sum;
        }

//        if (thing instanceof Wall){
//            result = sum <
//        }

        return result;
    }

    int getGunX() {
        return (int)Math.round((double)this.x + GUN_LENGTH * Math.sin(this.direction));
    }

    int getGunY() {
        return (int)Math.round((double)this.y + GUN_LENGTH * Math.cos(this.direction));
    }

    double getDirection() {
        return this.direction;
    }

    @Override
    int getRadius() { return RADIUS; }

    public void setLaserSound(SimpleAudioPlayer laserSound) {
        this.laserSound = laserSound;
    }

    public SimpleAudioPlayer getLaserSound() {
        return laserSound;
    }
}
