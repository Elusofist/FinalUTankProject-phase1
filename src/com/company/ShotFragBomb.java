package com.company;


import java.awt.*;

public class ShotFragBomb extends MovingThing {
    static final int RADIUS = 50;
    static final int LIFE = 70;
    int age = LIFE;

    ShotFragBomb(int x, int y, double d) {
        super(x, y, d, 1.0F, 1.0F);
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.RED);
        graphic.fillOval(this.x - Shot.RADIUS, this.y - Shot.RADIUS,
                Shot.RADIUS * 3, Shot.RADIUS * 3);
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