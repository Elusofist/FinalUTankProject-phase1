package com.company;

import javax.swing.*;

public class Window extends JFrame {
    MainMenu mainMenu;
    RulesMenu rulesMenu;
    KeyboardMenu keyboardMenu;
    Game game;

    Window(){
        super();
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
}
