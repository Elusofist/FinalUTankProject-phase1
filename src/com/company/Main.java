package com.company;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.setSize(Game.WIDTH,Game.HEIGHT);

        Window frame = Window.getInstance();
        frame.setSize(Game.WIDTH,Game.HEIGHT);
        frame.addKeyListener(new GameActionListener());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainMenu.setVisible(true);
        frame.add(mainMenu);
        frame.setMainMenu(mainMenu);


        RulesMenu rulesMenu = new RulesMenu();
        rulesMenu.setSize(Game.WIDTH,Game.HEIGHT);
        rulesMenu.setVisible(false);
        frame.setRulesMenu(rulesMenu);

        MiddleGameMenu middleGameMenu = new MiddleGameMenu();
        middleGameMenu.setSize(800, 810);
        frame.setMiddleGameMenu(middleGameMenu);
        middleGameMenu.setVisible(false);
        mainMenu.middleGameMenu = middleGameMenu;
        middleGameMenu.mainMenu = mainMenu;

        frame.setVisible(true);
    }
}


