package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.*;

public class Shot extends MovingThing {
    static final int RADIUS = 10;
    static final int LIFE = 70;
    int age = LIFE;

    Shot(int x, int y, double d) {
        super(x, y, d, 1, 1.5f);
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.BLACK);
        graphic.fillOval(this.x - Shot.RADIUS, this.y - Shot.RADIUS,
                Shot.RADIUS * 2, Shot.RADIUS * 2);
    }
    void growOld() {
        --this.age;
    }

    boolean isDead() {
        return this.age <= 0;
    }

    void kill() {
        this.age = 0;
    }

    @Override
    int getRadius() { return RADIUS; }

    void bounceAgainst(Wall wall) {
        this.direction = (wall.isVertical ? 0 : Math.PI) - this.direction;
        this.calculateVelocity();
    }
}
