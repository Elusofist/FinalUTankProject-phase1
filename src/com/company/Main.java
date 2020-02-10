package com.company;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.setSize(700,700);

        Window frame = Window.getInstance();
        frame.setSize(700,700);
        frame.addKeyListener(new GameActionListener());

        mainMenu.setVisible(true);
        frame.add(mainMenu);
        frame.setMainMenu(mainMenu);


        RulesMenu rulesMenu = new RulesMenu();
        rulesMenu.setSize(700,700);
        rulesMenu.setVisible(false);
        frame.setRulesMenu(rulesMenu);

        frame.setVisible(true);
    }
}


