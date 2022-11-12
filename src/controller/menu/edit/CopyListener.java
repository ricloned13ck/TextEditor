package controller.menu.edit;

import controller.Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Application.copy();
    }
}
