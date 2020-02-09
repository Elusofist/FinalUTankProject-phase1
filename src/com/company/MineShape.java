package com.company;

import java.awt.*;

public class MineShape extends PowerUp{
    MineShape(int x, int y) {
        super(x, y);
        this.circleColor = Color.BLACK;
        this.textColor = new Color(172, 47, 38);
        this.letter = "M";
    }


    @Override
    void draw(Graphics graphic) {

        super.draw(graphic, this.letter, this.circleColor, this.textColor);
    }}
