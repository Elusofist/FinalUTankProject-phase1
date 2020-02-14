package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RulesMenu extends JPanel {

    public RulesMenu() {
        JButton back = new JButton("Menu");
        this.add(back);
        back.addActionListener(actionEvent -> {
            Window frame = Window.getInstance();
            MainMenu mainMenu = new MainMenu();
            mainMenu.setSize(700,700);
            frame.setMainMenu(mainMenu);
            RulesMenu.super.setVisible(false);
            frame.mainMenu.setVisible(true);
        });

        JLabel roundsToWinLabel = new JLabel("Rounds To Win: ");
        this.add(roundsToWinLabel);

        JSlider roundsToWinSetter = new JSlider(JSlider.HORIZONTAL, 1, 10, 10);
        this.add(roundsToWinSetter);

        Font font = new Font("Serif", Font.ITALIC, 15);
        roundsToWinSetter.setMajorTickSpacing(2);
        roundsToWinSetter.setMinorTickSpacing(2);
        roundsToWinSetter.setPaintTicks(true);
        roundsToWinSetter.setPaintLabels(true);
        roundsToWinLabel.setFont(font);

        roundsToWinSetter.addChangeListener((ChangeListener) changeEvent -> {
            if (! roundsToWinSetter.getValueIsAdjusting()){
                int n = (int) roundsToWinSetter.getValue();
                Data.getInstance().setRoundsToWin(n);
            }
        });


        JLabel shotPerRoundLabel = new JLabel("Shots Per Round: ");
        this.add(shotPerRoundLabel);

        JSlider shotPerRoundSetter = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
        this.add(shotPerRoundSetter);

        shotPerRoundSetter.setMajorTickSpacing(10);
        shotPerRoundSetter.setMinorTickSpacing(1);
        shotPerRoundSetter.setPaintTicks(true);
        shotPerRoundSetter.setPaintLabels(true);
        font = new Font("Serif", Font.ITALIC, 15);
        shotPerRoundSetter.setFont(font);

        shotPerRoundSetter.addChangeListener((ChangeListener) changeEvent -> {
            if (! shotPerRoundSetter.getValueIsAdjusting()){
                int shotPerRound = (int) shotPerRoundSetter.getValue();
                Data.getInstance().setShotPerRound(shotPerRound);
            }
        });

        JLabel mapLabel = new JLabel("Choose Map: ");
        this.add(mapLabel);

        MapLevel[] names = {MapLevel.EASY, MapLevel.MEDIUM, MapLevel.HARD};
        JComboBox mapLevelSetter = new JComboBox(names);
        this.add(mapLevelSetter);
        mapLevelSetter.addActionListener(actionEvent -> {
            JComboBox cb = (JComboBox) actionEvent.getSource();
            MapLevel mapName = (MapLevel) cb.getSelectedItem();
            Data.getInstance().setMap(mapName);
        });


        JRadioButton isPredesigned = new JRadioButton("Use Predesigned map");
        this.add(isPredesigned);
        isPredesigned.addActionListener(actionEvent -> Data.getInstance().setMapPredesigned(true));

        JRadioButton isGenerated = new JRadioButton("Generate map");
        this.add(isGenerated);
        isGenerated.addActionListener(actionEvent -> Data.getInstance().setMapPredesigned(false));

        ButtonGroup group = new ButtonGroup();
        group.add(isGenerated); group.add(isPredesigned);


        JButton keySetting = new JButton("Key Settings");
        this.add(keySetting);
        keySetting.addActionListener(actionEvent -> {
            Window frame = Window.getInstance();
            RulesMenu.super.setVisible(false);
            frame.setVisible(true);
            KeyboardMenu keyboardMenu = new KeyboardMenu();
            frame.setKeyboardMenu(keyboardMenu);
            keyboardMenu.setSize(Window.WIDTH, Window.HEIGHT);
            keyboardMenu.setVisible(true);
            keyboardMenu.setFocusable(true);
            keyboardMenu.requestFocusInWindow();

        });

    }
}
