package view;

import view.menu.EditMenu;
import view.menu.FileMenu;
import view.menu.InfoMenu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar(){
        this.add(new FileMenu());
        this.add(new EditMenu());
        this.add(new InfoMenu());
    }
}
