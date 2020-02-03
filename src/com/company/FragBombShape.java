package com.company;

import java.awt.*;

public class FragBombShape extends PowerUpShape{
    FragBombShape(int x, int y) {
        super(x, y);
    }

    @Override
    void draw(Graphics graphic) {
        graphic.setColor(Color.GREEN);
        graphic.fillOval(this.x - 15, this.y - 15, 30, 30);
        graphic.setColor(Color.BLACK);
    }
}
