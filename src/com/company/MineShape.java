package com.company;

import java.awt.*;

public class MineShape extends PowerUpShape{
    MineShape(int x, int y) {
        super(x, y);
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.CYAN);
        graphic.fillOval(this.x - 15, this.y - 15, 30, 30);
        graphic.setColor(Color.BLACK);
    }
}
