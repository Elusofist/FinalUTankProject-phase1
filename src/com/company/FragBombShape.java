package com.company;

import java.awt.*;

public class FragBombShape extends PowerUp{

    FragBombShape(int x, int y) {
        super(x, y);
        this.circleColor = new  Color(41, 173, 10);
        this.textColor = new Color(0, 0, 0);
        this.letter = "FRAG";
    }


    @Override
    void draw(Graphics graphic) {

        super.draw(graphic, this.letter, this.circleColor, this.textColor);
    }}
