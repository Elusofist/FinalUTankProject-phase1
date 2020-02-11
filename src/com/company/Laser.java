package com.company;

import java.awt.*;

public class Laser extends MovingThing{

    final static int LIFESPAN = 500;

    Tank owner;
    int age;
    boolean isEmitting;
    double slope;

    Laser(int x, int y, Tank owner) {
        super(x, y, 0, 0, 0);
        this.age = Laser.LIFESPAN;
        this.owner = owner;
        this.direction = owner.direction;
        age = LIFESPAN;
        isEmitting = false;

    }

    void draw(Graphics graphic) {
        if (this.isEmitting) {
            graphic.setColor(Color.red);
            if (owner.getY() > owner.getGunY())
                graphic.drawLine(owner.getGunX(), owner.getGunY(), (int) (owner.getGunY() / (-1 / Math.tan(owner.getDirection())) + owner.getGunX()) + 1, 0);

            if (owner.getX() > owner.getGunX() && owner.getY() < owner.getGunY())
                graphic.drawLine(owner.getGunX(), owner.getGunY(), 0, (int) ((-1 / Math.tan(owner.getDirection())) * owner.getGunX() + owner.getGunY()));

            if (owner.getX() < owner.getGunX() && owner.getY() < owner.getGunY())
                graphic.drawLine(owner.getGunX(), owner.getGunY(), Game.WIDTH, (int) (((1 / Math.tan(owner.getDirection())) * (Game.WIDTH - owner.getGunX())) + owner.getGunY()));

            if (owner.getX() == owner.getGunX() && owner.getY() > owner.getGunY()) {
                graphic.drawLine(owner.getGunX(), owner.getGunY(), owner.getX(), 0);
            }
            if (owner.getX() == owner.getGunX() && owner.getY() < owner.getGunY()) {
                graphic.drawLine(owner.getGunX(), owner.getGunY(), owner.getX(), Game.HEIGHT);
            }
            if (owner.getX() > owner.getGunX() && owner.getY() == owner.getGunY()) {
                graphic.drawLine(owner.getGunX(), owner.getGunY(), 0, owner.getY());
            }
            if (owner.getX() < owner.getGunX() && owner.getY() == owner.getGunY()) {
                graphic.drawLine(owner.getGunX(), owner.getGunY(), Game.WIDTH, owner.getY());
            }
        }
    }

    void growOld(){ this.age--; }

    boolean isDead(){ return this.age <=0; }

    void update(){
        this.x          = owner.getGunX();
        this.y          = owner.getGunY();
        this.direction  = owner.direction;

    }

    @Override
    int getRadius() {
        return 0;
    }
}
