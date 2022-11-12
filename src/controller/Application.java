package controller;

import model.AbstractFileModel;
import model.TxtFileModel;
import view.MainWindow;
import view.MenuBar;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Application {
    private static AbstractFileModel model = null;
    private static MenuBar menuBar;
    private static MainWindow mainWindow;
    private static JTextPane textArea;
    private static DocumentListener documentListener;

    public static boolean isFileExists(File file) {
        return file.exists() && !file.isDirectory();
    }

    public static void run() {
        mainWindow = new MainWindow();
        menuBar = new MenuBar();
        textArea = new JTextPane();
        model = new TxtFileModel("untitled.txt");
        textArea.getDocument().addDocumentListener(new ContentChangerListener(model));
        mainWindow.setJMenuBar(menuBar);
        mainWindow.setTextArea(textArea);
        mainWindow.setVisible(true);
    }

    public static void clear() {
        save();
        textArea.getDocument().removeDocumentListener(documentListener);
        model = new TxtFileModel("untitled.txt");
        textArea.setText("");
        documentListener = new ContentChangerListener(model);
        textArea.getDocument().addDocumentListener(documentListener);

    }

    public static void save() {
        if (model.getIsNeedSave()) {
            int result = JOptionPane.showConfirmDialog(mainWindow, "Сохранить изменения?", "Новый файл", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    model.save();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void saveWithoutModal() {
        try {
            model.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAs() throws IOException {
        String m = JOptionPane.showInputDialog(mainWindow, "Введите имя файла без .txt", "Сохранить как", JOptionPane.INFORMATION_MESSAGE);
        String temp = textArea.getText().toString();

        model = new TxtFileModel(m + ".txt");
        File file = new File(m + ".txt");
        if (isFileExists(file)) {
            int result = JOptionPane.showConfirmDialog(mainWindow, "Файл уже существует, заменить его?", "Файл существует", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                textArea.setText("");
                documentListener = new ContentChangerListener(model);
                textArea.getDocument().addDocumentListener(documentListener);
                textArea.setText(temp);
                model.save();
            }
        } else {
            textArea.setText("");
            documentListener = new ContentChangerListener(model);
            textArea.getDocument().addDocumentListener(documentListener);
            textArea.setText(temp);
            model.save();
        }
    }

    public static void open() {
        save();
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(mainWindow);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                textArea.getDocument().removeDocumentListener(documentListener);
                model = new TxtFileModel(fileChooser.getSelectedFile().getAbsolutePath());
                model.open();
                textArea.setText(model.getContent());
                documentListener = new ContentChangerListener(model);
                textArea.getDocument().addDocumentListener(documentListener);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void exit() {
        save();
        System.exit(0);
    }

    public static void copy() {
        String toCopy = textArea.getSelectedText();
        if (toCopy != null) {
            StringSelection stringSelection = new StringSelection(toCopy);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
        } else {
            StringSelection stringSelection = new StringSelection("");
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
        }
    }

    public static void cut() {
        copy();

        textArea.setText(textArea.getText().replace(textArea.getSelectedText(), ""));
    }

    public static void insert() throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String toCopy = textArea.getSelectedText();

        if (Objects.equals(toCopy, null)) {
            Transferable t = clipboard.getContents(null);
            String insertText = (String) t.getTransferData(DataFlavor.stringFlavor);

            int cursor = textArea.getSelectionStart();
            String startText = textArea.getText().substring(0, cursor);
            String endText = textArea.getText().substring(cursor);
            String text = startText + insertText + endText;

            textArea.setText(text);
        } else {
            Transferable t = clipboard.getContents(null);
            String insertText = (String) t.getTransferData(DataFlavor.stringFlavor);
            textArea.setText(textArea.getText().replace(textArea.getSelectedText(), insertText));
        }
    }

    public static void bold() {
        StyledDocument doc = (StyledDocument) textArea.getDocument();
        Element element = doc.getCharacterElement(0);
        AttributeSet as = element.getAttributes();

        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
        doc.setCharacterAttributes(0, textArea.getText().length(), asNew, true);

    }

    public static void italic() {
        StyledDocument doc = (StyledDocument) textArea.getDocument();
        Element element = doc.getCharacterElement(0);
        AttributeSet as = element.getAttributes();

        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
        doc.setCharacterAttributes(0, textArea.getText().length(), asNew, true);
    }

    public static void underlined() {
        StyledDocument doc = (StyledDocument) textArea.getDocument();
        Element element = doc.getCharacterElement(0);
        AttributeSet as = element.getAttributes();

        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
        doc.setCharacterAttributes(0, textArea.getText().length(), asNew, true);
    }

    public static void info() {
        JOptionPane.showMessageDialog(mainWindow, "TextEditor by Aleksey Kuznetsov\nДанный калькулятор был создан на уроках Кирилла Анатольевича\n\nⒸ2022-2022. All rights reserved", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }
}
