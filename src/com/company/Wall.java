package com.company;

import java.awt.*;

public class Wall extends Thing {
    final static int WIDTH = 6;

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
        int width = (this.isVertical) ? Wall.WIDTH : this.i2 - this.i1;
        int height = (this.isVertical) ? this.i2 - this.i1 : Wall.WIDTH;
        graphic.fillRect(this.getX(), this.getY(), width, height);
    }

    boolean contacts(MovingThing moving) {
        int mI = (this.isVertical)? moving.getY() : moving.getX();
        int mJ = (this.isVertical)? moving.getX() : moving.getY();

        int start = Math.min(this.i1, this.i2);
        int end = Math.max(this.i1, this.i2);

        int near = (Math.abs(mI - start) < Math.abs(mI - end))?
                        start :
                        end;

        int contactJ = mJ + ((this.j <= mJ)? -1 : 1) * moving.getRadius();

        return (start <= mI && mI <= end &&
                this.j <= contactJ &&
                contactJ <= this.j + Wall.WIDTH)
                ||
                Math.sqrt(Math.pow(mI - near, 2d) + Math.pow(mJ - this.j, 2d)) <= moving.getRadius();
    }

}
