package com.company;

import java.awt.*;

public class Mine extends PowerUpShot {
    static final int RADIUS = 20;
    static final int LIFE = 500;
    static final int ALERT_RADIUS = 100;
    Tank foe;
    int age = 500;

    Mine(int x, int y, Tank foe) {
        super(x, y);
        this.foe = foe;
    }

    void draw(Graphics graphic) {
        int distance = (int)Math.sqrt(Math.pow((this.x - this.foe.getX()), 2) + Math.pow((this.getY() - this.foe.getY()), 2));
        if (distance < 100) {
            graphic.setColor(Color.GRAY);
            graphic.fillOval(this.x - 20, this.y - 20, 40, 40);
            graphic.setColor(Color.RED);
            graphic.fillOval(this.x - 6, this.y - 6, 13, 13);
            graphic.setColor(Color.BLACK);
        }

    }

    void growOld() {
        --this.age;
    }

    void kill() {
        this.age = 0;
    }

    boolean isDead() {
        return this.age <= 0;
    }
}
