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

//    boolean contacts(MovingThing movingThing) {
//        int mI = (this.isVertical)? movingThing.getY() : movingThing.getX();
//        int mJ = (this.isVertical)? movingThing.getX() : movingThing.getY();
//
//        int start = Math.min(this.i1, this.i2);
//        int end = Math.max(this.i1, this.i2);
//
//        int contactJ = mJ +
//
//                ((this.j <= mJ)? -1 : 1) *
//                        movingThing.getRadius();
//
//        return (
//                start <= mI + movingThing.getRadius() &&
//                        mI - movingThing.getRadius() <= end &&
//                        mJ + movingThing.getRadius() >= this.j &&
//                        mJ - movingThing.getRadius() <= WIDTH + this.j
//        );
//    }

//    boolean contacts(MovingThing movingThing) {
//        int distance = 0;
//        boolean result = false;
//        if (this.isVertical) {
//            if (movingThing.x >= this.x && movingThing.x <= this.x + Wall.WIDTH) {
//                distance = this.y - movingThing.y;
//            } else if (movingThing.y >= this.y && movingThing.y <= Math.abs(this.i1 - this.i2)) {
//                distance = movingThing.x - this.x;
//            }
//        } else {
//            if (movingThing.y >= this.y && movingThing.y <= this.y + Wall.WIDTH) {
//                distance = movingThing.x - this.x;
//            } else if (movingThing.x >= this.x && movingThing.x <= Math.abs(this.i1 - this.i2)) {
//                distance = this.y - movingThing.y;
//            }
//        }
//
//        if (distance < 0 && Math.abs(distance) >= Math.abs(this.i1 - this.i2) + movingThing.getRadius())
//            result = true;
//        else if (distance > movingThing.getRadius()) result = true;
//        return result;
//    }

//    boolean contacts (MovingThing movingThing) {
//        boolean res;
//        if (!isVertical){
//            res = movingThing.x + movingThing.getRadius() >= this.i1
//                    && movingThing.x - movingThing.getRadius() <= this.i2
//                    && movingThing.y + movingThing.getRadius() >= this.j
//                    && movingThing.y - movingThing.getRadius() <= this.j + WIDTH;
//        } else {
//            res = movingThing.y + movingThing.getRadius() >= this.i1
//                    && movingThing.y - movingThing.getRadius() <= this.i2
//                    && movingThing.x + movingThing.getRadius() >= this.j
//                    && movingThing.x - movingThing.getRadius() <= this.j + WIDTH;
//        }
//        return res;
//    }

    boolean contacts(MovingThing movingThing) {
        int lengthStart = Math.min(this.i1, this.i2);
        int lengthEnd = Math.max(this.i1, this.i2);
        int widthStart = this.j;
        int widthEnd = this.j + WIDTH;
//
////        Rectangle
        boolean result = lengthStart - ((isVertical) ? movingThing.getY() : movingThing.getX()) <= movingThing.getRadius()
                && ((isVertical) ? movingThing.getY() : movingThing.getX()) - lengthEnd <= movingThing.getRadius()
                && widthStart - ((isVertical) ? movingThing.getX() : movingThing.getY()) <= movingThing.getRadius()
                && ((isVertical) ? movingThing.getX() : movingThing.getY()) - widthEnd <= movingThing.getRadius();

        if (!result) {
            double radian = Math.atan2((movingThing.getY() - lengthStart), (movingThing.getX() - widthStart - WIDTH / 2));
            double distance = Math.sqrt(Math.pow((movingThing.getX() - widthStart - WIDTH / 2), 2)
                    + Math.pow((movingThing.getY() - lengthStart), 2));
            double standardRadian = Math.atan2(Math.abs(lengthStart - movingThing.getX()), (WIDTH / 2));
            double standardDistance = Math.sqrt(Math.pow((WIDTH / 2), 2) + Math.pow((movingThing.getY() - lengthStart), 2));

            if (radian % Math.PI >= standardRadian
                    && radian % Math.PI <= Math.PI - standardRadian
                    && distance <= standardDistance)
                result = true;
        }

//                if (!result) {
//                    double radian = Math.atan((movingThing.getY() - lengthEnd)/ (movingThing.getX() - widthStart - WIDTH/2);
//                    double distance = Math.sqrt((Math.pow((m))))
//                }

                return result;
//    }

    }


}
