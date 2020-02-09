package com.company;

import java.awt.*;


public abstract class PowerUp extends Thing {
    final static int RADIUS = 15;
    final static int LIFE = 500; //step
    int age;
    int glowingRadius = 3;
    int glowingInterval = 15;

    // ina dige tooye oon powerup taeen mishan
    Color circleColor;
    Color textColor;
    String letter;

    PowerUp(int x, int y) {
        super(x, y);
        age = PowerUp.LIFE;
    }

    void draw(Graphics graphic, String letter, Color circleColor, Color textColor){
        graphic.setColor(circleColor);
        graphic.fillOval(this.x - PowerUp.RADIUS + (int)(Math.cos(Game.time * Math.PI / glowingInterval) * glowingRadius)
                , this.y - PowerUp.RADIUS + (int)(Math.cos(Game.time * Math.PI / glowingInterval) * glowingRadius)
                , (PowerUp.RADIUS -(int)(Math.cos(Game.time * Math.PI / glowingInterval) * glowingRadius)) * 2
                , (PowerUp.RADIUS -(int)(Math.cos(Game.time * Math.PI / glowingInterval) * glowingRadius) )* 2);
        graphic.setColor(textColor);
        graphic.setFont(new Font("Arial", Font.BOLD, 15));
        graphic.drawString(letter, this.x - 7, this.y + 6);

        graphic.setColor(Color.BLACK);
    }

    void growOld() { this.age--; }

    boolean isDead() { return this.age <= 0; }

    void kill() { this.age = 0; }

    public static int getRADIUS() {
        return PowerUp.RADIUS;
    }
}
