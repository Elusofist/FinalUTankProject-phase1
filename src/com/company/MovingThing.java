package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public abstract class MovingThing extends Thing {
    private final static float MAX_VEL = 7, THRUST_ACC = 0.3f, FRICTION_ACC = 0.2f;
    double direction;
    float velocity;
    float vX, vY;
    float angularVelocity;

    MovingThing(int x, int y, double d, float a, float v0) {
        super(x, y);
        this.velocity = v0;
        this.angularVelocity = a;
        this.direction = d;
        this.calculateVelocity();
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
        this.calculateVelocity();
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

    void calculateVelocity() {
        this.vX = Math.round(this.velocity * Math.sin(this.direction));
        this.vY = Math.round(this.velocity * Math.cos(this.direction));
    }

    void blocked(Wall wall) {
        if (wall.isVertical) {
            if ((this.x <= wall.j && this.vX > 0) || (this.x >= wall.j && this.vX < 0))
                this.vX = 0;
        } else {
            if ((this.y <= wall.j && this.vY > 0) || (this.y >= wall.j && this.vY < 0))
                this.vY = 0;
        }
    }

    void step() {
        this.x += this.vX;
        this.y += this.vY;
    }

    public void velocityInc(){
        // ta vaqti ke v az max kamtare, ye meqdar e xassi ziadesh mikone
        if (this.velocity < MAX_VEL) {
            this.velocity+= THRUST_ACC;
        }
        this.calculateVelocity();
    }

    public void velocityDec(){
        // ta vaqti ke v az min bishtare, ye meqdar e xassi kamesh mikone
        if (this.velocity > - MAX_VEL) {
            this.velocity-= THRUST_ACC;
        }
        this.calculateVelocity();
    }

    public void speedDown(){
        // andaze ye sor'at ro kam mikone; che sor'at mosbat bashe, che manfi
        if (this.velocity < 0)
            this.velocity += FRICTION_ACC;
        else if (this.velocity > 0)
            this.velocity-= FRICTION_ACC;

        this.calculateVelocity();
    }
}
