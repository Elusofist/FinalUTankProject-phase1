package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


class Map{
    private List<Wall> walls = new ArrayList<>();

    Map (MapLevel level) {
        switch (level) {
            case EASY:
                easyMapDesigner(walls);
                break;
            case MEDIUM:
                mediumMapDesigner(walls);
                break;
            case HARD:
                hardMapDesigner(walls);
                break;
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    static void easyMapDesigner(List<Wall> walls) {
        walls.add(new Wall(0,0, 800, false));
        walls.add(new Wall(0,0, 800, true));
        walls.add(new Wall(0,794,800, false));
        walls.add(new Wall(794, 0, 800, true));
        walls.add(new Wall(0, 200, 100, false));
        walls.add(new Wall(0, 400, 800/3, false));
        walls.add(new Wall(800/6, 400, 100, true));
        walls.add(new Wall(800/3, 300, 100, true));
        walls.add(new Wall(800/3, 700, 100, true));
        walls.add(new Wall(400, 0, 100, true));
        walls.add(new Wall(500, 400, 400, true));
        walls.add(new Wall(400, 500, 100, false));
        walls.add(new Wall(700, 200, 100, false));
        walls.add(new Wall(700, 600, 100, false));
    }

    static void mediumMapDesigner(List<Wall> walls) {
        walls.add(new Wall(0,0, 800, false));
        walls.add(new Wall(0,0, 800, true));
        walls.add(new Wall(0,794,800, false));
        walls.add(new Wall(794, 0, 800, true));
        walls.add(new Wall(0, 200, 100, false));
        walls.add(new Wall(100, 0, 200, true));
        walls.add(new Wall(100, 400, 300, true));
        walls.add(new Wall(100, 100, 100, false));
        walls.add(new Wall(100, 300, 100, false));
        walls.add(new Wall(100, 700, 100, false));
        walls.add(new Wall(200, 500, 100, false));
        walls.add(new Wall(200, 600, 100, false));
        walls.add(new Wall(300, 0, 100, true));
        walls.add(new Wall(300, 500, 100, true));
        walls.add(new Wall(300, 700, 100, true));
        walls.add(new Wall(300, 100, 100, false));
        walls.add(new Wall(400, 600, 100, true));
        walls.add(new Wall(500, 0, 100, true));
        walls.add(new Wall(700, 700, 100, true));
        walls.add(new Wall(500, 100, 200, false));
        walls.add(new Wall(600, 200, 100, false));
        walls.add(new Wall(700, 200, 100, true));
        walls.add(new Wall(600, 300, 100, true));
        walls.add(new Wall(500, 400, 200, false));
        walls.add(new Wall(600, 600, 200, false));
    }

    static void hardMapDesigner(List<Wall> walls) {
        walls.add(new Wall(0,0, 800, false));
        walls.add(new Wall(0,0, 800, true));
        walls.add(new Wall(0,794,800, false));
        walls.add(new Wall(794, 0, 800, true));
        walls.add(new Wall(0, 100, 100, false));
        walls.add(new Wall(100, 100, 100, true));
        walls.add(new Wall(0, 200, 100, false));
        walls.add(new Wall(100, 300, 200, true));
        walls.add(new Wall(200, 600, 300, false));
        walls.add(new Wall(400, 700, 100, true));
        walls.add(new Wall(0, 500, 100, false));
        walls.add(new Wall(0, 600, 100, false));
        walls.add(new Wall(100, 700, 100, true));
        walls.add(new Wall(100, 700, 200, false));
        walls.add(new Wall(500, 700, 100, true));
        walls.add(new Wall(300, 100, 100, true));
        walls.add(new Wall(400, 700, 100, true));
        walls.add(new Wall(200, 0, 200, true));
        walls.add(new Wall(200, 300, 100, true));
        walls.add(new Wall(200, 500, 100, true));
        walls.add(new Wall(300, 100, 100, false));
        walls.add(new Wall(400, 0, 200, true));
        walls.add(new Wall(600, 0, 100, true));
        walls.add(new Wall(300, 300, 100, false));
        walls.add(new Wall(300, 300, 100, true));
        walls.add(new Wall(300, 500, 100, true));
        walls.add(new Wall(400, 400, 100, false));
        walls.add(new Wall(400, 500, 200, false));
        walls.add(new Wall(500, 200, 100, true));
        walls.add(new Wall(500, 200, 100, false));
        walls.add(new Wall(600, 200, 200, true));
        walls.add(new Wall(600, 500, 100, true));
        walls.add(new Wall(600, 600, 200, false));
        walls.add(new Wall(600, 700, 100, false));
        walls.add(new Wall(700, 700, 100, true));
        walls.add(new Wall(700, 0, 200, true));
        walls.add(new Wall(700, 200, 100, false));
        walls.add(new Wall(700, 300, 100, true));
    }

    void draw(Graphics graphics) {
        walls.forEach(wall -> wall.draw(graphics));
    }
}
