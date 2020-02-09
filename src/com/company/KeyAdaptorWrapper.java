package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


public class KeyAdaptorWrapper extends KeyAdapter {
    static List<Integer> chosenKeysCodes = new ArrayList<>();
    boolean p1Move = false, p1Left = false, p1Right = false, p1Down = false, p1Fire = false;
    boolean p2Move = false, p2Left = false, p2Right = false, p2Down = false, p2Fire = false;

    static public Integer setChosenKeysCodes(KeyListener e) {
        KeyEvent k = (KeyEvent) e;
        switch (k.getKeyCode()) {
            case KeyEvent.VK_0:
                chosenKeysCodes.add(KeyEvent.VK_0);
                break;
            case KeyEvent.VK_1:
                chosenKeysCodes.add(KeyEvent.VK_1);
                break;
            case KeyEvent.VK_2:
                chosenKeysCodes.add(KeyEvent.VK_2);
                break;
            case KeyEvent.VK_3:
                chosenKeysCodes.add(KeyEvent.VK_3);
                break;
            case KeyEvent.VK_4:
                chosenKeysCodes.add(KeyEvent.VK_4);
                break;
            case KeyEvent.VK_5:
                chosenKeysCodes.add(KeyEvent.VK_5);
                break;
            case KeyEvent.VK_6:
                chosenKeysCodes.add(KeyEvent.VK_6);
                break;
            case KeyEvent.VK_7:
                chosenKeysCodes.add(KeyEvent.VK_7);
                break;
            case KeyEvent.VK_8:
                chosenKeysCodes.add(KeyEvent.VK_8);
                break;
            case KeyEvent.VK_9:
                chosenKeysCodes.add(KeyEvent.VK_9);
                break;
            case KeyEvent.VK_A:
                chosenKeysCodes.add(KeyEvent.VK_A);
                break;
            case KeyEvent.VK_B:
                chosenKeysCodes.add(KeyEvent.VK_B);
                break;
            case KeyEvent.VK_C:
                chosenKeysCodes.add(KeyEvent.VK_C);
                break;
            case KeyEvent.VK_D:
                chosenKeysCodes.add(KeyEvent.VK_D);
                break;
            case KeyEvent.VK_E:
                chosenKeysCodes.add(KeyEvent.VK_E);
                break;
            case KeyEvent.VK_F:
                chosenKeysCodes.add(KeyEvent.VK_F);
                break;
            case KeyEvent.VK_G:
                chosenKeysCodes.add(KeyEvent.VK_G);
                break;
            case KeyEvent.VK_H:
                chosenKeysCodes.add(KeyEvent.VK_H);
                break;
            case KeyEvent.VK_I:
                chosenKeysCodes.add(KeyEvent.VK_I);
                break;
            case KeyEvent.VK_J:
                chosenKeysCodes.add(KeyEvent.VK_J);
                break;
            case KeyEvent.VK_K:
                chosenKeysCodes.add(KeyEvent.VK_K);
                break;
            case KeyEvent.VK_L:
                chosenKeysCodes.add(KeyEvent.VK_L);
                break;
            case KeyEvent.VK_M:
                chosenKeysCodes.add(KeyEvent.VK_M);
                break;
            case KeyEvent.VK_N:
                chosenKeysCodes.add(KeyEvent.VK_N);
                break;
            case KeyEvent.VK_O:
                chosenKeysCodes.add(KeyEvent.VK_O);
                break;
            case KeyEvent.VK_P:
                chosenKeysCodes.add(KeyEvent.VK_P);
                break;
            case KeyEvent.VK_Q:
                chosenKeysCodes.add(KeyEvent.VK_Q);
                break;
            case KeyEvent.VK_R:
                chosenKeysCodes.add(KeyEvent.VK_R);
                break;
            case KeyEvent.VK_S:
                chosenKeysCodes.add(KeyEvent.VK_S);
                break;
            case KeyEvent.VK_T:
                chosenKeysCodes.add(KeyEvent.VK_T);
                break;
            case KeyEvent.VK_U:
                chosenKeysCodes.add(KeyEvent.VK_U);
                break;
            case KeyEvent.VK_V:
                chosenKeysCodes.add(KeyEvent.VK_V);
                break;
            case KeyEvent.VK_W:
                chosenKeysCodes.add(KeyEvent.VK_W);
                break;
            case KeyEvent.VK_X:
                chosenKeysCodes.add(KeyEvent.VK_X);
                break;
            case KeyEvent.VK_Y:
                chosenKeysCodes.add(KeyEvent.VK_Y);
                break;
            case KeyEvent.VK_Z:
                chosenKeysCodes.add(KeyEvent.VK_Z);
                break;
            case KeyEvent.VK_ALT:
                chosenKeysCodes.add(KeyEvent.VK_ALT);
                break;
            case KeyEvent.VK_BACK_QUOTE:
                chosenKeysCodes.add(KeyEvent.VK_BACK_QUOTE);
                break;
            case KeyEvent.VK_BACK_SLASH:
                chosenKeysCodes.add(KeyEvent.VK_BACK_SLASH);
                break;
            case KeyEvent.VK_BACK_SPACE:
                chosenKeysCodes.add(KeyEvent.VK_BACK_SPACE);
                break;
            case KeyEvent.VK_BRACELEFT:
                chosenKeysCodes.add(KeyEvent.VK_BRACELEFT);
                break;
            case KeyEvent.VK_BRACERIGHT:
                chosenKeysCodes.add(KeyEvent.VK_BRACERIGHT);
                break;
            case KeyEvent.VK_CLOSE_BRACKET:
                chosenKeysCodes.add(KeyEvent.VK_CLOSE_BRACKET);
                break;
            case KeyEvent.VK_OPEN_BRACKET:
                chosenKeysCodes.add(KeyEvent.VK_OPEN_BRACKET);
                break;
            case KeyEvent.VK_CAPS_LOCK:
                chosenKeysCodes.add(KeyEvent.VK_CAPS_LOCK);
                break;
            case KeyEvent.VK_COLON:
                chosenKeysCodes.add(KeyEvent.VK_COLON);
                break;
            case KeyEvent.VK_COMMA:
                chosenKeysCodes.add(KeyEvent.VK_COMMA);
                break;
            case KeyEvent.VK_CONTROL:
                chosenKeysCodes.add(KeyEvent.VK_CONTROL);
                break;
            case KeyEvent.VK_DELETE:
                chosenKeysCodes.add(KeyEvent.VK_DELETE);
                break;
            case KeyEvent.VK_DOWN:
                chosenKeysCodes.add(KeyEvent.VK_DOWN);
                break;
            case KeyEvent.VK_PAGE_DOWN:
                chosenKeysCodes.add(KeyEvent.VK_PAGE_DOWN);
                break;
            case KeyEvent.VK_END:
                chosenKeysCodes.add(KeyEvent.VK_END);
                break;
            case KeyEvent.VK_ENTER:
                chosenKeysCodes.add(KeyEvent.VK_ENTER);
                break;
            case KeyEvent.VK_EQUALS:
                chosenKeysCodes.add(KeyEvent.VK_EQUALS);
                break;
            case KeyEvent.VK_ESCAPE:
                chosenKeysCodes.add(KeyEvent.VK_ESCAPE);
                break;
            case KeyEvent.VK_F1:
                chosenKeysCodes.add(KeyEvent.VK_F1);
                break;
            case KeyEvent.VK_F2:
                chosenKeysCodes.add(KeyEvent.VK_F2);
                break;
            case KeyEvent.VK_F3:
                chosenKeysCodes.add(KeyEvent.VK_F3);
                break;
            case KeyEvent.VK_F4:
                chosenKeysCodes.add(KeyEvent.VK_F4);
                break;
            case KeyEvent.VK_F5:
                chosenKeysCodes.add(KeyEvent.VK_F5);
                break;
            case KeyEvent.VK_F6:
                chosenKeysCodes.add(KeyEvent.VK_F6);
                break;
            case KeyEvent.VK_F7:
                chosenKeysCodes.add(KeyEvent.VK_F7);
                break;
            case KeyEvent.VK_F8:
                chosenKeysCodes.add(KeyEvent.VK_F8);
                break;
            case KeyEvent.VK_F9:
                chosenKeysCodes.add(KeyEvent.VK_F9);
                break;
            case KeyEvent.VK_F10:
                chosenKeysCodes.add(KeyEvent.VK_F10);
                break;
            case KeyEvent.VK_F11:
                chosenKeysCodes.add(KeyEvent.VK_F11);
                break;
            case KeyEvent.VK_F12:
                chosenKeysCodes.add(KeyEvent.VK_F12);
                break;
            case KeyEvent.VK_GREATER:
                chosenKeysCodes.add(KeyEvent.VK_GREATER);
                break;
            case KeyEvent.VK_HOME:
                chosenKeysCodes.add(KeyEvent.VK_HOME);
                break;
            case KeyEvent.VK_LEFT:
                chosenKeysCodes.add(KeyEvent.VK_LEFT);
                break;
            case KeyEvent.VK_LEFT_PARENTHESIS:
                chosenKeysCodes.add(KeyEvent.VK_LEFT_PARENTHESIS);
                break;
            case KeyEvent.VK_LESS:
                chosenKeysCodes.add(KeyEvent.VK_LESS);
                break;
            case KeyEvent.VK_MINUS:
                chosenKeysCodes.add(KeyEvent.VK_MINUS);
                break;
            case KeyEvent.VK_INSERT:
                chosenKeysCodes.add(KeyEvent.VK_INSERT);
                break;
            case KeyEvent.VK_PAUSE:
                chosenKeysCodes.add(KeyEvent.VK_PAUSE);
                break;
            case KeyEvent.VK_QUOTE:
                chosenKeysCodes.add(KeyEvent.VK_QUOTE);
                break;
            case KeyEvent.VK_QUOTEDBL:
                chosenKeysCodes.add(KeyEvent.VK_QUOTEDBL);
                break;
            case KeyEvent.VK_RIGHT:
                chosenKeysCodes.add(KeyEvent.VK_RIGHT);
                break;
            case KeyEvent.VK_RIGHT_PARENTHESIS:
                chosenKeysCodes.add(KeyEvent.VK_RIGHT_PARENTHESIS);
                break;
            case KeyEvent.VK_SPACE:
                chosenKeysCodes.add(KeyEvent.VK_SPACE);
                break;
            case KeyEvent.VK_SHIFT:
                chosenKeysCodes.add(KeyEvent.VK_SHIFT);
                break;
            case KeyEvent.VK_SLASH:
                chosenKeysCodes.add(KeyEvent.VK_SLASH);
                break;
            case KeyEvent.VK_TAB:
                chosenKeysCodes.add(KeyEvent.VK_TAB);
                break;
            case KeyEvent.VK_UP:
                chosenKeysCodes.add(KeyEvent.VK_UP);
                break;
            case KeyEvent.VK_PAGE_UP:
                chosenKeysCodes.add(KeyEvent.VK_PAGE_UP);
                break;
            case KeyEvent.VK_WINDOWS:
                chosenKeysCodes.add(KeyEvent.VK_WINDOWS);
                break;
        }
        return chosenKeysCodes.get(0);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int value = e.getKeyCode();
        if (value == chosenKeysCodes.get(0)) {
            p1Move = true;
        } else if (value == chosenKeysCodes.get(1)){
            p1Down = true;
        }  else if (value == chosenKeysCodes.get(2)){
            p1Left = true;
        } else if (value == chosenKeysCodes.get(3)){
            p1Right = true;
        } else if (value == chosenKeysCodes.get(4)){
            p1Fire = true;
        } else if (value == chosenKeysCodes.get(5)){
            p2Move = true;
        } else if (value == chosenKeysCodes.get(6)){
            p2Down = true;
        } else if (value == chosenKeysCodes.get(7)){
            p2Left = true;
        } else if (value == chosenKeysCodes.get(8)){
            p2Right = true;
        } else if (value == chosenKeysCodes.get(9)){
            p2Fire = true;
        }
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int value = e.getKeyCode();
        if (value == chosenKeysCodes.get(0)) {
            p1Move = false;
        } else if (value == chosenKeysCodes.get(1)){
            p1Down = false;
        }  else if (value == chosenKeysCodes.get(2)){
            p1Left = false;
        } else if (value == chosenKeysCodes.get(3)){
            p1Right = false;
        } else if (value == chosenKeysCodes.get(4)){
            p1Fire = false;
        } else if (value == chosenKeysCodes.get(5)){
            p2Move = false;
        } else if (value == chosenKeysCodes.get(6)){
            p2Down = false;
        } else if (value == chosenKeysCodes.get(7)){
            p2Left = false;
        } else if (value == chosenKeysCodes.get(8)){
            p2Right = false;
        } else if (value == chosenKeysCodes.get(9)){
            p2Fire = false;
        }
        e.consume();
    }
}
