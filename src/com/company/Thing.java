package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.Graphics;

public abstract class Thing {
    int x;
    int y;

    Thing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics var1);

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

//    abstract boolean contact(Thing thing);
}
