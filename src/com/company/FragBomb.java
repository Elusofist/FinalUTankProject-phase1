package com.company;

import java.awt.*;

public class FragBomb extends PowerUpShot {

    FragBomb(int x, int y, double d, float v, float a) {
        super(x, y, d, v, a);
    }

    boolean contacts(Tank tank) {
        int sum = Tank.RADIUS + FragBomb.RADIUS;
        int distance = (int) Math.sqrt(Math.pow(this.x - tank.getX(), 2) + Math.pow(this.y - tank.getY(), 2));
        return sum >= distance;
    }

    boolean contacts(Wall wall) {
        int distance = 0;
        if (wall.isVertical) {
            if (this.x >= wall.x && this.x <= wall.x + Wall.WIDTH) {
                distance = wall.y - this.y;
            } else if (this.y >= wall.y && this.y <= Math.abs(wall.i1 - wall.i2)) {
                distance = this.x - wall.x;
            }
        } else {
            if (this.y >= wall.y && this.y <= wall.y + Wall.WIDTH) {
                distance = this.x - wall.x;
            } else if (this.x >= wall.x && this.x <= Math.abs(wall.i1 - wall.i2)) {
                distance = wall.y - this.y;
            }
        }
        return distance <= RADIUS;
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.darkGray);
        graphic.fillOval(this.x - RADIUS, this.y - RADIUS, RADIUS * 2, RADIUS * 2);
    }
}
