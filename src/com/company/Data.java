package com.company;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static Data dataInstance;

    static Data getInstance(){
        if(dataInstance == null)
            dataInstance = new Data();

        return dataInstance;
    }

    private int shotPerRound;
    private int roundsToWin;
    private Map map;
    private List<Integer> p1Keyboard = new ArrayList<>();
    private List<Integer> p2Keyboard = new ArrayList<>();
    private boolean isMapPredesigned;


    Data() {
        isMapPredesigned = true;
        map = new Map(MapLevel.EASY);
        shotPerRound = 20;
        roundsToWin = 5;
        p1Keyboard.add(32); p1Keyboard.add(37); p1Keyboard.add(38); p1Keyboard.add(39); p1Keyboard.add(40);
        p2Keyboard.add(65); p2Keyboard.add(68); p2Keyboard.add(70); p2Keyboard.add(83); p2Keyboard.add(87);
    }


    public void setP1Keyboard(List<Integer> p1Keyboard) {
        this.p1Keyboard = p1Keyboard;
    }

    public void setShotPerRound(int shotPerRound) {
        this.shotPerRound = shotPerRound;
    }

    public void setRoundsToWin(int roundsToWin) {
        this.roundsToWin = roundsToWin;
    }

    public void setMap(String mapName) {
        if (mapName == "Easy"){
            if(isMapPredesigned)
                this.map = new Map(MapLevel.EASY);
        }
        else if (mapName == "Medium"){
            if(isMapPredesigned)
                this.map = new Map(MapLevel.MEDIUM);
        }
        else if (mapName == "Hard"){
            if(isMapPredesigned)
                this.map = new Map(MapLevel.HARD);
        }
    }

    public void setP2Keyboard(List<Integer> p2Keyboard) {
        this.p2Keyboard = p2Keyboard;
    }

    void show(){
        System.out.println("shot per round: " + this.shotPerRound);
        System.out.println("round to win: " + this.roundsToWin);
        System.out.println("use predesigned map: " + this.isMapPredesigned);
        System.out.println(this.map);
        System.out.println(this.p1Keyboard);
        System.out.println(this.p2Keyboard);
        System.out.println();
    }

    public int getShotPerRound() {
        return shotPerRound;
    }

    public int getRoundToWin() {
        return roundsToWin;
    }

    public Map getMap() {
        return map;
    }

    public List<Integer> getP1Keyboard() {
        return p1Keyboard;
    }

    public List<Integer> getP2Keyboard() {
        return p2Keyboard;
    }

    public void setMapPredesigned(boolean mapPredesigned) {
        isMapPredesigned = mapPredesigned;
    }
}
