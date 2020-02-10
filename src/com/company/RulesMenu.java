package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesMenu extends JPanel {
    static String data;

    public RulesMenu() {
        JButton back = new JButton("back to main menu");
        this.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Window frame = Window.getInstance();
                MainMenu mainMenu = new MainMenu();
                mainMenu.setSize(700,700);
                frame.setMainMenu(mainMenu);
                RulesMenu.super.setVisible(false);
                frame.mainMenu.setVisible(true);
                System.out.println(data);
            }
        });

        String[] names = {"mammad", "qolamreza", "morteza", "akbar"};
        JComboBox namebox = new JComboBox(names);
        this.add(namebox);
        namebox.setSelectedIndex(3);
        namebox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JComboBox cb = (JComboBox) actionEvent.getSource();
                String myname = (String) cb.getSelectedItem();
                data = myname;
            }
        });
    }

    public static String getData() {
        return data;
    }
}
