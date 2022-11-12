package controller.menu.info;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Application.info();
    }
}
