package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeyboardMenu extends JPanel {

    public KeyboardMenu() {

        // reset keyboards
        Data.getInstance().setP1Keyboard(new ArrayList<Integer>());
        Data.getInstance().setP2Keyboard(new ArrayList<Integer>());

        JLabel label = new JLabel("Choose keys for your game");
        this.add(label);

        /*
            bara vaqti ke hameye dokme ha moshaxxas nashodan va yaroo mizane roo back
         */
        JLabel completionError = new JLabel("please complete key assignment");
        completionError.setForeground(Color.RED);
        completionError.setVisible(false);
        this.add(completionError);

        JLabel keyMatchError = new JLabel("This key is assigned to another function. Choose another key.");
        keyMatchError.setForeground(Color.RED);
        keyMatchError.setVisible(false);
        this.add(keyMatchError);

        JLabel finalMessage = new JLabel("Assignment Completed.");
        finalMessage.setForeground(new Color(0, 167, 14));
        finalMessage.setVisible(false);
        this.add(finalMessage);

        JTextArea a = new JTextArea("(Player1) Forward Move? ");
        a.setFont(new Font("Arial", Font.ITALIC, 20));
        a.setEditable(false);
        this.add(a);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                SimpleAudioPlayer keyClick = null;
                try {
                    keyClick = new SimpleAudioPlayer("keyClick.wav");
                } catch (UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (LineUnavailableException ex) {
                    ex.printStackTrace();
                }
                keyClick.play();

                List<Integer> p1Keys = Data.getInstance().getP1Keyboard();
                List<Integer> p2Keys = Data.getInstance().getP2Keyboard();
                keyMatchError.setVisible(false);
                completionError.setVisible(false);

                if (p2Keys.size() < 5) {
                    if ( (!p1Keys.contains(e.getKeyCode())) && (!p2Keys.contains(e.getKeyCode()))) {
                        if (p2Keys.size() == 4) {
                            p2Keys.add(e.getKeyCode());
                            a.append(KeyEvent.getKeyText(e.getKeyCode()));
                            a.setFocusable(false);
                            finalMessage.setVisible(true);
                        } else {
                            if (p1Keys.size() < 5) {
                                p1Keys.add(e.getKeyCode());
                                a.append(KeyEvent.getKeyText(e.getKeyCode()) + "\n");
                                if (p1Keys.size() == 1)
                                    a.append("(Player1) Move Down? ");
                                if (p1Keys.size() == 2)
                                    a.append("(Player1) Left? ");
                                if (p1Keys.size() == 3)
                                    a.append("(Player1) Right? ");
                                if (p1Keys.size() == 4)
                                    a.append("(Player1) Fire? ");
                                if (p1Keys.size() == 5)
                                    a.append("(Player2) Move Forward? ");
                            } else {
                                p2Keys.add(e.getKeyCode());
                                a.append(KeyEvent.getKeyText(e.getKeyCode()) + "\n");
                                if (p2Keys.size() == 1)
                                    a.append("(Player2) Move Down? ");
                                if (p2Keys.size() == 2)
                                    a.append("(Player2) Left? ");
                                if (p2Keys.size() == 3)
                                    a.append("(Player2) Right? ");
                                if (p2Keys.size() == 4)
                                    a.append("(Player2) Fire? ");
                            }

                        }
                    }
                    else {
                        keyMatchError.setVisible(true);
                    }
                }

                e.consume();
            }
        });

        JButton back = new JButton("Back");
        this.add(back);
        back.addActionListener(actionEvent -> {

            SimpleAudioPlayer beep = null;
            try {
                beep = new SimpleAudioPlayer("buttonBeep.wav");
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            beep.play();

            if (Data.getInstance().getP2Keyboard().size() == 5) {
                KeyboardMenu.super.setVisible(false);
                Window.getInstance().rulesMenu.setVisible(true);
            }
            else {
                completionError.setVisible(true);
                a.requestFocusInWindow();
            }
         });

    }
}
