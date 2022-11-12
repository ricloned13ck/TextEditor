package view;

import controller.menu.file.ExitListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JTextPane textArea;
    private JScrollPane pane;

    public MainWindow() {
        MenuBar menuBar = new MenuBar();
        setTitle("TextEditor");
        addWindowListener(new ExitListener());
        Dimension screenDimension = getToolkit().getScreenSize();
        Dimension windowDimension = new Dimension(screenDimension.width / 2, screenDimension.height / 2);
        Point windowLocation = new Point(screenDimension.width / 4, screenDimension.height / 4);
        setSize(windowDimension);
        setLocation(windowLocation);
        setLayout(new BorderLayout());
        setVisible(true);
    }

    public void setTextArea(JTextPane textArea) {
        this.textArea = textArea;
        this.pane = new JScrollPane(this.textArea);
        this.add(this.pane, BorderLayout.CENTER);
    }
}
