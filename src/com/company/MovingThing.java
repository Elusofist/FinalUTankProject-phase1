package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public abstract class MovingThing extends Thing {
    double direction;
    float velocity;
    float angularVelocity;

    MovingThing(int x, int y, double d, float a) {
        super(x, y);
        this.velocity = 0;
        this.angularVelocity = a;
        this.direction = d;
    }

    public void changeVelocity() {
        if (this.velocity < 10) {
            this.velocity++;
        }
    }

    public void changeNegVelocity() {
        if (this.velocity > 0) {
            this.velocity--;
        }
    }

    private void changeDirection(double amount) {
        this.direction = (this.direction + amount) % 6.283185307179586D;
    }

    public void addPIToDirection() {
        this.direction += Math.PI;
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

    public void velocityInc(){
        // ta vaqti ke v az max kamtare, ye meqdar e xassi ziadesh mikone
        if (this.velocity < 10) {
            this.velocity+= 0.5;
        }
    }

    public void velocityDec(){
        // ta vaqti ke v az min bishtare, ye meqdar e xassi kamesh mikone
        if (this.velocity > -10) {
            this.velocity-= 0.5;
        }
    }

    public void speedDown(){
        // andaze ye sor'at ro kam mikone; che sor'at mosbat bashe, che manfi
        if (this.velocity < 0)
            this.velocity += 0.2;
        else if (this.velocity > 0)
            this.velocity-= 0.2;
    }
}
