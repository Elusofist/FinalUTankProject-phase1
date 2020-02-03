package com.company;

import java.awt.*;

public class Mine extends PowerUpShot {
    static final int ALERT_RADIUS = 100;
    Tank foe;

    Mine(int x, int y, double d, float v, float a) {
        super(x, y, d, v, a);
    }

    void draw(Graphics graphic) {
        int distance = (int)Math.sqrt(Math.pow((this.x - this.foe.getX()), 2) + Math.pow((this.getY() - this.foe.getY()), 2));
        if (distance < ALERT_RADIUS) {
            graphic.setColor(Color.GRAY);
            graphic.fillOval(this.x - RADIUS, this.y - RADIUS, RADIUS * 2, RADIUS * 2);
            graphic.setColor(Color.RED);
            graphic.fillOval(this.x - RADIUS/3, this.y - RADIUS/3, (RADIUS * 2)/3, (RADIUS * 2)/3);
            graphic.setColor(Color.BLACK);
        }
    }

}
