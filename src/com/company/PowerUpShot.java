package com.company;

abstract public class PowerUpShot extends MovingThing {
    static final int RADIUS = 20;
    static final int LIFE = 500;
    int age = LIFE;

    PowerUpShot(int x, int y, double d, float v, float a) {
        super(x, y, d, v, a);
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

    int getRadius() { return RADIUS; }
}
