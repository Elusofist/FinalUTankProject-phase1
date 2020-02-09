package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KeyboardMenu extends JFrame {
    List<Integer> keyboards = new ArrayList<>();
//    List<KeyAdaptorWrapper> keyboardDefiner() {
//         List<KeyAdaptorWrapper> chosenKeyboards = new ArrayList<>();
//         this.addKeyListener(new KeyAdapter() {
//         });
    void update() {
        KeyAdaptorWrapper k = (KeyAdaptorWrapper) this.getKeyListeners()[0];
        keyboards.add(KeyAdaptorWrapper.setChosenKeysCodes(k));
    }

    void setKeyboards() {
        if (keyboards.size() < 10) {
            update();
        }
    }
//         for (int i = 0; i < 10; i++) {
//             chosenKeyboards.add((KeyAdaptorWrapper) this.getKeyListeners()[0]);
//         }
//         return chosenKeyboards;
//     }
}
