package com.company;

import javax.swing.*;

public class Main {

    final static int WIDTH = 800;
    final static int HEIGHT = 800;

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.setSize(WIDTH,HEIGHT);

        Window frame = Window.getInstance();
        frame.setSize(WIDTH,HEIGHT);
        frame.addKeyListener(new GameActionListener());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainMenu.setVisible(true);
        frame.add(mainMenu);
        frame.setMainMenu(mainMenu);


        RulesMenu rulesMenu = new RulesMenu();
        rulesMenu.setSize(WIDTH,HEIGHT);
        rulesMenu.setVisible(false);
        frame.setRulesMenu(rulesMenu);

        MiddleGameMenu middleGameMenu = new MiddleGameMenu();
        middleGameMenu.setSize(800, 810);
        frame.setMiddleGameMenu(middleGameMenu);
        middleGameMenu.setVisible(false);
        mainMenu.middleGameMenu = middleGameMenu;
        middleGameMenu.mainMenu = mainMenu;

//        KeyboardMenu keyboardMenu = new KeyboardMenu();
//        keyboardMenu.setSize(WIDTH,HEIGHT);
//        keyboardMenu.setVisible(false);
//        frame.setKeyboardMenu(keyboardMenu);

        frame.setVisible(true);
    }
}


