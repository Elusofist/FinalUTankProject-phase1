package com.company;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class GameActionListener extends KeyAdapter {
    boolean p1Move;
    boolean p1Left;
    boolean p1Right;
    boolean p1Down;
    boolean p1Fire;
    boolean p2Move;
    boolean p2Left;
    boolean p2Right;
    boolean p2Down;
    boolean p2Fire;

    List<Integer> p1Keyboard;
    List<Integer> p2Keyboard;


    public GameActionListener() {
        this.p1Keyboard = Data.getInstance().getP1Keyboard();
        this.p2Keyboard = Data.getInstance().getP2Keyboard();
    }

    public void keyPressed(KeyEvent e) {

        int k = e.getKeyCode();

        if (k == p1Keyboard.get(0))
            this.p1Move = true;
        else if ( k == p1Keyboard.get(1))
            this.p1Down = true;
        else if ( k == p1Keyboard.get(2))
            this.p1Left = true;
        else if ( k == p1Keyboard.get(3))
            this.p1Right = true;
        else if ( k == p1Keyboard.get(4))
            this.p1Fire = true;

        else if (k == p2Keyboard.get(0))
            this.p2Move = true;
        else if (k == p2Keyboard.get(1))
            this.p2Down = true;
        else if (k == p2Keyboard.get(2))
            this.p2Left = true;
        else if (k == p2Keyboard.get(3))
            this.p2Right = true;
        else if (k == p2Keyboard.get(4))
            this.p2Fire = true;

        e.consume();
    }

    public void keyReleased(KeyEvent e) {

        int k = e.getKeyCode();

        if (k == p1Keyboard.get(0))
            this.p1Move = false;
        else if ( k == p1Keyboard.get(1))
            this.p1Down = false;
        else if ( k == p1Keyboard.get(2))
            this.p1Left = false;
        else if ( k == p1Keyboard.get(3))
            this.p1Right = false;
        else if ( k == p1Keyboard.get(4))
            this.p1Fire = false;

        else if (k == p2Keyboard.get(0))
            this.p2Move = false;
        else if (k == p2Keyboard.get(1))
            this.p2Down = false;
        else if (k == p2Keyboard.get(2))
            this.p2Left = false;
        else if (k == p2Keyboard.get(3))
            this.p2Right = false;
        else if (k == p2Keyboard.get(4))
            this.p2Fire = false;

        e.consume();
    }
}
