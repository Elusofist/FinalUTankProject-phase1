package com.company;

import java.awt.*;

public class LaserShape extends PowerUp{

    LaserShape(int x, int y) {
        super(x, y);
        this.circleColor = new Color(243, 23, 255);
        this.textColor = Color.WHITE;
        this.letter = "L";
    }

    @Override
    void draw(Graphics graphic) {

        super.draw(graphic, this.letter, this.circleColor, this.textColor);
    }
}