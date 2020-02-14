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

    // Up, Down, Left, Right, Fire
    private List<Integer> p1Keyboard;
    private List<Integer> p2Keyboard;

    private boolean isMapPredesigned;
    private MapLevel mapLevel;


    Data() {
        // Default settings
        isMapPredesigned = true;
        mapLevel = MapLevel.EASY;
        map = new Map(MapLevel.EASY, true);
        shotPerRound = 20;
        roundsToWin = 5;
        p1Keyboard = new ArrayList<>();
        p2Keyboard = new ArrayList<>();
        p1Keyboard.add(KeyEvent.VK_UP);
        p1Keyboard.add(KeyEvent.VK_DOWN);
        p1Keyboard.add(KeyEvent.VK_LEFT);
        p1Keyboard.add(KeyEvent.VK_RIGHT);
        p1Keyboard.add(KeyEvent.VK_SPACE);


        p2Keyboard.add(KeyEvent.VK_W);
        p2Keyboard.add(KeyEvent.VK_S);
        p2Keyboard.add(KeyEvent.VK_A);
        p2Keyboard.add(KeyEvent.VK_D);
        p2Keyboard.add(KeyEvent.VK_F);
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

    public void setMap(String mapName, boolean isMapPredesigned) {
        this.isMapPredesigned = isMapPredesigned;
        if (mapName == "Easy"){
            this.mapLevel = MapLevel.EASY;
            this.map = new Map(MapLevel.EASY, isMapPredesigned);
        }

        else if (mapName == "Medium") {
            this.mapLevel = MapLevel.MEDIUM;
            this.map = new Map(MapLevel.MEDIUM, isMapPredesigned);
        }

        else if (mapName == "Hard") {
            this.mapLevel = MapLevel.HARD;
            this.map = new Map(MapLevel.HARD, isMapPredesigned);
        }

    }

    public void modifyMap(){
        this.map = new Map(this.mapLevel, this.isMapPredesigned);
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

    public MapLevel getMapLevel() {
        return mapLevel;
    }

    public boolean getIsMapPredesigned() {
        return isMapPredesigned;
    }
}
