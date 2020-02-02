package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Player {
    static final int FULL_AMMO = 10;
    Tank tank;
    int point = 0;
    int ammo = 10;

    public Player() {
    }

    void newRound(boolean hasWon, double startX, double startY) {
        this.ammo = 10;
        if (hasWon) {
            ++this.point;
        } else {
            this.tank = new Tank((int)startX, (int)startY, 0.0D);
        }

    }

    Tank getTank() {
        return this.tank;
    }
}
