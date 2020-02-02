package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.Timer;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.addKeyListener(new GameActionListener());
        game.setVisible(true);
        (new Timer(10, (e) -> {
            game.updateState();
            game.repaint();
        })).start();
    }
}


