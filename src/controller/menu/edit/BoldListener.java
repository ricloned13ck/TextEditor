package controller.menu.edit;

import controller.Application;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoldListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Application.bold();
    }
}
