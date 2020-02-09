package com.company;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Data {

    int shotPerRound;
    int roundToWin;
    Map map;
    List<Integer> p1Keyboard = new ArrayList<>();
    List<Integer> p2Keyboard = new ArrayList<>();

    Data() {
        shotPerRound = 20;
        roundToWin = 5;
        map = new Map(MapLevel.EASY);
        p1Keyboard.add(32); p1Keyboard.add(37); p1Keyboard.add(38); p1Keyboard.add(39); p1Keyboard.add(40);
        p2Keyboard.add(65); p2Keyboard.add(68); p2Keyboard.add(70); p2Keyboard.add(83); p2Keyboard.add(87);
    }

    Data(int shotPerRound, int roundToWin, MapLevel level,
         ArrayList<Integer> p1Keyboard, ArrayList<Integer> p2Keyboard) {
        this.shotPerRound = shotPerRound;
        this.roundToWin = roundToWin;
        map = new Map(level);
        this.p1Keyboard = p1Keyboard;
        this.p2Keyboard = p2Keyboard;
    }
}
