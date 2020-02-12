package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Player {
    final int FULL_AMMO = Data.getInstance().getShotPerRound();
    Tank tank;
    int point = 0;
    int ammo;

    public Player() {
    }

    void newRound(boolean hasWon, double startX, double startY) {
        this.ammo = FULL_AMMO;
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
