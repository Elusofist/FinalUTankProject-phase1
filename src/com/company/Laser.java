package com.company;

import java.awt.*;

public class Laser extends PowerUpShot {
    Laser(int x, int y, double d, float v, float a) {
        super(x, y, d, v, a);
    }

    @Override
    int getRadius() {
        return 0;
    }

    @Override
    void draw(Graphics var1) {

    }
}
