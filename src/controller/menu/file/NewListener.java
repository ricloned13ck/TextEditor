package controller.menu.file;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Application.clear();
    }
}
