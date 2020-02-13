package com.company;

import java.awt.*;

public class Laser extends MovingThing{

    final static int LIFESPAN = 1000;

    Tank owner;
    int age;
    boolean isEmitting;

    Laser(int x, int y, Tank owner) {
        super(x, y, 0,0);
        this.age = Laser.LIFESPAN;
        this.owner = owner;
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
//    public double contacts(int x, int y) {
//        double dis;
//        if (owner.getY() > owner.getGunY() && y < owner.getGunY()) {
//            dis = Math.abs((y - owner.getGunY() + ((-1 / Math.tan(owner.getDirection())) * (x - owner.getGunX())))/Math.sqrt(Math.pow((-1 / Math.tan(owner.getDirection())), 2.0D) + Math.pow(1, 2.0D)));
//            return dis;
//        }
//
//        if (owner.getX() > owner.getGunX() && owner.getY() < owner.getGunY() && y > owner.getGunY()) {
//            dis = Math.abs((y - owner.getGunY() + ((-1 / Math.tan(owner.getDirection())) * (x - owner.getGunX())))/Math.sqrt(Math.pow((-1 / Math.tan(owner.getDirection())), 2.0D) + Math.pow(1, 2.0D)));
//            return dis;
//        }
//
//        if (owner.getX() < owner.getGunX() && owner.getY() < owner.getGunY() && y > owner.getGunY()) {
//            dis = Math.abs((y - owner.getGunY() - ((1 / Math.tan(owner.getDirection())) * (x - owner.getGunX())))/Math.sqrt(Math.pow((1 / Math.tan(owner.getDirection())), 2.0D) + Math.pow(1, 2.0D)));
//            return dis;
//        }
//
//        if (owner.getX() == owner.getGunX() && owner.getY() > owner.getGunY()){
//            dis = Math.abs(x- owner.getGunX());
//            return dis;
//        }
//
//        if (owner.getX() == owner.getGunX() && owner.getY() < owner.getGunY()){
//            dis = Math.abs(x- owner.getGunX());
//            return dis;
//        }
//
//        if (owner.getX() > owner.getGunX() && owner.getY() == owner.getGunY()){
//            dis = Math.abs(this.y- owner.getGunY());
//            return dis;
//        }
//
//        if (owner.getX() < owner.getGunX() && owner.getY() == owner.getGunY()){
//            dis = Math.abs(this.y- owner.getGunY());
//            return dis;
//        }
//
//        return 75;
//    }

    public void growOld() { --this.age; }

    public boolean isDead() { return this.age <= 0; }

    public void kill() { this.age = 0; }

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
