package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public class Tank extends MovingThing {
    static final int RADIUS = 25;
    final static int GUN_LENGTH = 40;

    Tank(int x, int y, double d) {
        super(x, y, d, 2.0F, 0.06F);
    }

    void draw(Graphics graphic) {
        graphic.drawOval(this.x - 25, this.y - 25, 50, 50);
        graphic.drawLine(this.x, this.y, this.getGunX(), this.getGunY());
    }

    boolean contacts(Thing thing) {
        boolean result = false;
        int distance = (int)Math.sqrt(Math.pow((double)(this.x - thing.getX()), 2.0D) + Math.pow((double)(this.getY() - thing.getY()), 2.0D));
        int sum;
        if (thing instanceof Shot) {
            sum = 35;
            result = distance <= sum;
        }

        if (thing instanceof Tank) {
            sum = 50;
            result = distance <= sum;
        }

        if (thing instanceof PowerUpShape) {
            sum = 40;
            result = distance <= sum;
        }

        if (thing instanceof PowerUpShot) {
            sum = 40;
            result = distance <= sum;
        }

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
}
