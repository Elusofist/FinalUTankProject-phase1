package com.company;

import java.awt.*;

public class Mine extends Thing implements PowerUpUtility{
    final static int RADIUS = 20;
    final static int LIFESPAN = LIFE;
    final static int ALERT_RADIUS = 100;

    Tank foe; // nesbat be tank e harif
    int age;

    Mine(int x, int y, Tank foe) {
        super(x, y);
        this.age = Mine.LIFESPAN;
        this.foe = foe;
    }


    @Override
    void draw(Graphics graphic) {
        int distance = (int) Math.sqrt((Math.pow((this.x - foe.getX()),2) + (Math.pow((this.getY() - foe.getY()),2))));
        if (distance < ALERT_RADIUS){
            graphic.setColor(Color.GRAY);
            graphic.fillOval(this.x - Mine.RADIUS, this.y - Mine.RADIUS,
                    Mine.RADIUS * 2, Mine.RADIUS * 2);
            if (Math.floor(Game.time / 10) % 2 == 0) {
                graphic.setColor(Color.RED);
                graphic.fillOval(this.x - (Mine.RADIUS) / 3, this.y - (Mine.RADIUS) / 3,
                        (Mine.RADIUS * 2) / 3, (Mine.RADIUS * 2) / 3);
            }
            graphic.setColor(Color.BLACK);
        }
    }

    public void growOld(){ this.age--; }

    public void kill() { this.age = 0;}

    public boolean isDead(){ return this.age <= 0; }

}
