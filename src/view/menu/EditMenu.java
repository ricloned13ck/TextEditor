package view.menu;

import controller.menu.edit.*;

import javax.swing.*;

public class EditMenu extends JMenu {
    public EditMenu(){
        super("Правка");
        setMnemonic('П');

        JMenuItem copyMenuItem = new JMenuItem("Копировать");
        copyMenuItem.setMnemonic('c');
        copyMenuItem.addActionListener(new CopyListener());
        add(copyMenuItem);

        JMenuItem cutMenuItem = new JMenuItem("Вырезать");
        cutMenuItem.setMnemonic('C');
        cutMenuItem.addActionListener(new CutListener());
        add(cutMenuItem);

        JMenuItem insertMenuItem = new JMenuItem("Вставить");
        insertMenuItem.setMnemonic('I');
        insertMenuItem.addActionListener(new InsertListener());
        add(insertMenuItem);

        addSeparator();

        JMenuItem boldMenuItem = new JMenuItem("Жирный");
        boldMenuItem.setMnemonic('B');
        boldMenuItem.addActionListener(new BoldListener());
        add(boldMenuItem);

        JMenuItem italicMenuItem = new JMenuItem("Курсив");
        italicMenuItem.setMnemonic('T');
        italicMenuItem.addActionListener(new ItalicListener());
        add(italicMenuItem);

        JMenuItem underlinedMenuItem = new JMenuItem("Подчеркнутый");
        underlinedMenuItem.setMnemonic('G');
        underlinedMenuItem.addActionListener(new UnderlinedListener());
        add(underlinedMenuItem);
    }
}
