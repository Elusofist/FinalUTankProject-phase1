package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {


    public MainMenu() {

        JButton start = new JButton("Start");
        this.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Window frame = Window.getInstance();
                MainMenu.super.setVisible(false);
                frame.setVisible(true);

                Game game = new Game();
                frame.setGame(game);
                game.setSize(700, 700);
                game.setVisible(true);
                game.setFocusable(true);
                game.requestFocusInWindow();

                game.addKeyListener(new GameActionListener());


                new Timer(
                        10,
                        e -> {
                            game.updateState();
                            game.repaint();
                        }
                ).start();

            }
        });


        JButton quit = new JButton("Quit");
        this.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // what to do here;
                Window frame = Window.getInstance();
                frame.dispose();
            }
        });

        JButton rules = new JButton("Rules");
        this.add(rules);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainMenu.super.setVisible(false);
                Window.getInstance().rulesMenu.setVisible(true);
            }
        });

        JButton showData = new JButton("Show Data");
        this.add(showData);
        showData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Data.getInstance().show();
            }
        });
    }
}
