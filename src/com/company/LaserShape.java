package com.company;

import java.awt.*;

public class LaserShape extends PowerUpShape{
    LaserShape(int x, int y) {
        super(x, y);
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.ORANGE);
        graphic.fillOval(this.x - 15, this.y - 15, 30, 30);
        graphic.setColor(Color.BLACK);
    }
}
