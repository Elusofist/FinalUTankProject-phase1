package com.company;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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


    public GameActionListener() {
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 32:
                this.p1Fire = true;
                break;
            case 37:
                this.p1Left = true;
                System.out.println("!!!");
                break;
            case 38:
                this.p1Move = true;
                break;
            case 39:
                this.p1Right = true;
                break;
            case 40:
                this.p1Down = true;
                break;
            case 65:
                this.p2Left = true;
                break;
            case 68:
                this.p2Right = true;
                break;
            case 70:
                this.p2Fire = true;
                break;
            case 83:
                this.p2Down = true;
                break;
            case 87:
                this.p2Move = true;
        }

        e.consume();
    }

    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 32:
                this.p1Fire = false;
                break;
            case 37:
                this.p1Left = false;
                break;
            case 38:
                this.p1Move = false;
                break;
            case 39:
                this.p1Right = false;
                break;
            case 40:
                this.p1Down = false;
                break;
            case 65:
                this.p2Left = false;
                break;
            case 68:
                this.p2Right = false;
                break;
            case 70:
                this.p2Fire = false;
                break;
            case 83:
                this.p2Down = false;
                break;
            case 87:
                this.p2Move = false;
        }

        e.consume();
    }
}
