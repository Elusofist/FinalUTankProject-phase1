package com.company;

import java.awt.*;

public class FragBomb extends MovingThing implements PowerUpUtility{
    final static int RADIUS = 20;
    int age = LIFE;

    FragBomb(int x, int y, double d, float v, float a) {
        super(x, y, d, v, a);
    }

    boolean contacts(Tank tank) {
        int sum = tank.RADIUS + RADIUS;
        int distance = (int) Math.sqrt(Math.pow(this.x - tank.getX(), 2) + Math.pow(this.y - tank.getY(), 2));
        return sum >= distance;
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.darkGray);
        graphic.fillOval(this.x - RADIUS, this.y - RADIUS, RADIUS * 2, RADIUS * 2);
    }

    @Override
    public void growOld() { --this.age; }

    @Override
    public boolean isDead() {
        return this.age <= 0;
    }

    @Override
    public void kill() { this.age = 0; }

    @Override
    public int getRadius() {
        return this.getRadius();
    }
}