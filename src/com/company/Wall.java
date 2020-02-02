package com.company;

import java.awt.*;

public class Wall extends Thing{
    final static int WIDTH = 1;

    int i1, i2, j;
    boolean isVertical;

    Wall(int x, int y, int length, boolean isVertical) {
        super(x, y);
        this.isVertical = isVertical;
        if (isVertical) {
            this.i1 = y;
            this.i2 = y + length;
            this.j = x;
        } else {
            this.i1 = x;
            this.i2 = x + length;
            this.j = y;
        }
    }

    @Override
    void draw(Graphics graphic) {
        int width = (this.isVertical)? Wall.WIDTH : this.i2 - this.i1;
        int height = (this.isVertical)? this.i2 - this.i1 : Wall.WIDTH;
        graphic.fillRect(this.getX(), this.getY(), width, height);
    }

    boolean contacts(MovingThing movingThing) {
        int mI = (this.isVertical)? movingThing.getY() : movingThing.getX();
        int mJ = (this.isVertical)? movingThing.getX() : movingThing.getY();

        int start = Math.min(this.i1, this.i2);
        int end = Math.max(this.i1, this.i2);

        int contactJ = mJ +
                ((this.j <= mJ)? -1 : 1) *
                        movingThing.getRadius();

        return (
                start <= mI + movingThing.getRadius() &&
                        mI - movingThing.getRadius() <= end &&
                        this.j - Wall.WIDTH <= contactJ &&
                        contactJ <= this.j + Wall.WIDTH
        );
    }
}
