package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public abstract class MovingThing extends Thing {
    double direction;
    float velocity;
    float angularVelocity;

    MovingThing(int x, int y, double d, float v, float a) {
        super(x, y);
        this.velocity = v;
        this.angularVelocity = a;
        this.direction = d;
    }

    private void changeDirection(double amount) {
        this.direction = (this.direction + amount) % 6.283185307179586D;
    }

    public void turnLeft() {
        this.changeDirection((double)this.angularVelocity);
    }

    public void turnRight() {
        this.changeDirection((double)(-this.angularVelocity));
    }

    abstract int getRadius();

    void step() {
        this.x = (int)((long)this.x + Math.round((double)this.velocity * Math.sin(this.direction)));
        this.y = (int)((long)this.y + Math.round((double)this.velocity * Math.cos(this.direction)));
    }

    void negStep() {
        this.x -= Math.round(this.velocity * Math.sin(this.direction));
        this.y -= Math.round(this.velocity * Math.cos(this.direction));
    }
}
