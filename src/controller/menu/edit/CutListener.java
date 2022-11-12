package controller.menu.edit;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CutListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Application.cut();
    }
}
