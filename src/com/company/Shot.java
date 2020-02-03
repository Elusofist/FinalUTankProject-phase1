package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public class Shot extends MovingThing {
    static final int RADIUS = 10;
    static final int LIFE = 70;
    int age = LIFE;

    Shot(int x, int y, double d) {
        super(x, y, d, 3.0F, 0.0F);
    }

    void draw(Graphics graphic) {
        graphic.fillOval(this.x - RADIUS, this.y - RADIUS, RADIUS * 2, RADIUS * 2);
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
    }
}
