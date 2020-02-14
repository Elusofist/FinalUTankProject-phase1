package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiddleGameMenu extends JPanel {
    MainMenu mainMenu;
    public MiddleGameMenu(){
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JPanel buttonCenter = new JPanel(new GridBagLayout());
        buttonCenter.setBorder(new EmptyBorder(300, 0, 0, 0));

        JButton back = new JButton("Back To Menu");
        buttonPanel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MiddleGameMenu.super.setVisible(false);
                mainMenu.setVisible(true);

            }
        });

        JButton resume = new JButton("Resume");
        buttonPanel.add(resume);
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MiddleGameMenu.super.setVisible(false);
                Window.getInstance().game.setVisible(true);
                Window.getInstance().game.setFocusable(true);
                Window.getInstance().game.requestFocusInWindow();

            }
        });

        JButton quit = new JButton("Quit");
        buttonPanel.add(quit);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Window window = Window.getInstance();
                window.setVisible(false);
            }
        });

        buttonCenter.add(buttonPanel);
        this.add(buttonCenter, BorderLayout.LINE_END);
    }

}

