package com.company;

public abstract class PowerUp extends Thing {
    static final int RADIUS = 15;
    static final int LIFE = 500;
    int age = 500;

    PowerUp(int x, int y) {
        super(x, y);
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
}