package view.menu;

import controller.menu.info.InfoListener;

import javax.swing.*;

public class InfoMenu extends JMenu {
    public InfoMenu(){
        super("Справка");
        setMnemonic('О');

        JMenuItem infoMenuItem = new JMenuItem("О программе");
        infoMenuItem.setMnemonic('о');
        infoMenuItem.addActionListener(new InfoListener());
        add(infoMenuItem);

    }
}
