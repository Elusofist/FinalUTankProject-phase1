package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

//        MainMenu mainMenu = new MainMenu();
//        mainMenu.setSize(700,700);
//
//        Window frame = new Window();
//        frame.setSize(700,700);
//        mainMenu.frame = frame;
//
//        mainMenu.setVisible(true);
//        frame.add(mainMenu);
//        frame.setMainMenu(mainMenu);
//
//
//        RulesMenu rulesMenu = new RulesMenu();
//        rulesMenu.setSize(700,700);
//        rulesMenu.setVisible(false);
//        frame.setRulesMenu(rulesMenu);
//
//        frame.setLayout(null);
//        frame.setVisible(true);
        Game game = new Game();
        game.addKeyListener(new GameActionListener());
        game.setVisible(true);


        new Timer(
                10,
                e -> {
                    game.updateState();
                    game.repaint();
                }
        ).start();
    }
}


