package controller;

import model.AbstractFileModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class ContentChangerListener implements DocumentListener {
    private AbstractFileModel model = null;

    public ContentChangerListener(AbstractFileModel model){
        this.model=model;
    }

    private void onChange(DocumentEvent e) throws BadLocationException {
        String text = e.getDocument().getText(0,e.getDocument().getLength());
        model.setContent(text);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            onChange(e);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            onChange(e);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        try {
            onChange(e);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}
