package com.company;

import java.awt.*;

public class ScoreBoard extends Thing {

    int p1Point, p2Point;

    ScoreBoard(int x, int y){
        super(x, y);
    }

    void draw(Graphics graphic) {
        graphic.setColor(Color.RED);
        graphic.setColor(new Color(126,0,0));
        graphic.fillRect(Game.WIDTH / 2 - 30 , Game.HEIGHT - 70, 70, 40);
        graphic.setColor(new Color(228, 205, 174));
        graphic.setFont(new Font("Serif", Font.BOLD, 20));
        graphic.drawString(p1Point + " - " + p2Point, this.x, this.y);


    }

    public void setP1Point(int p1Point) {
        this.p1Point = p1Point;
    }

    public void setP2Point(int p2Point) {
        this.p2Point = p2Point;
    }
}