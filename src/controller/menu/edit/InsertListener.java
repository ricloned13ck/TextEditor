package controller.menu.edit;

import controller.Application;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Application.insert();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (UnsupportedFlavorException ex) {
            ex.printStackTrace();
        }
    }
}
