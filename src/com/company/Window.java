package com.company;

import javax.swing.*;

public class Window extends JFrame {
    private static Window windowInstance;

    static Window getInstance() {
        if (windowInstance == null)
            windowInstance = new Window();

        return windowInstance;
    }

    MainMenu mainMenu;
    RulesMenu rulesMenu;
    KeyboardMenu keyboardMenu;
    Game game;

    static final int WIDTH = 800, HEIGHT = 800;

    private Window(){
        super();
    }

    public GameActionListener getListener() {
        return (GameActionListener) this.getKeyListeners()[0];
    }

    public void setMainMenu(MainMenu mainMenu) {
        if (this.mainMenu != null)
            this.remove(this.mainMenu);

        this.mainMenu = mainMenu;
        this.add(mainMenu);
    }

    public void setRulesMenu(RulesMenu rulesMenu) {
        if (this.rulesMenu != null)
            this.remove(this.rulesMenu);

        this.rulesMenu = rulesMenu;
        this.add(rulesMenu);
    }

    public void setGame(Game game) {
        if (this.game != null)
            this.remove(this.game);

        this.game = game;
        this.add(game);
    }

    public void setKeyboardMenu(KeyboardMenu keyboardMenu) {
        if (this.keyboardMenu != null)
            this.remove(this.keyboardMenu);

        this.keyboardMenu = keyboardMenu;
        this.add(keyboardMenu);
    }
}
