package view.menu;

import controller.menu.file.*;

import javax.swing.*;

public class FileMenu extends JMenu {
    public FileMenu(){
        super("Файл");
        setMnemonic('Ф');

        JMenuItem newMenuItem = new JMenuItem("Новый");
        newMenuItem.setMnemonic('H');
        newMenuItem.addActionListener(new NewListener());
        add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Сохранить");
        saveMenuItem.setMnemonic('C');
        saveMenuItem.addActionListener(new SaveListener());
        add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Сохранить как");
        saveAsMenuItem.setMnemonic('K');
        saveAsMenuItem.addActionListener(new SaveAsListener());
        add(saveAsMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Открыть");
        openMenuItem.setMnemonic('G');
        openMenuItem.addActionListener(new OpenListener());
        add(openMenuItem);

        addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Выйти");
        exitMenuItem.setMnemonic('B');
        exitMenuItem.addActionListener(new ExitListener());
        add(exitMenuItem);
    }
}
