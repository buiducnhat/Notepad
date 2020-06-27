package com.gerpan.notepad.util;

import java.awt.Component;
import javax.swing.*;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JFontChooser {

    // Declare variables
    private JFrame mainFrame;
    private JButton submitButton;
    private JComboBox fontList;
    private JComboBox styleList;
    private JSlider sizeSlider;
    private JTextField sampleTextField;
    private JLabel fontLabel, styleLabel, sizeLabel, sampleLabel, sizeNumber;
    private Font font;
    private String fontName;
    private int fontStyle;
    private int fontSize;
    // End declaration

    //constructor with para is JTextArea (ta in Notepad.java), can change with other data as JTextField,...)
    public JFontChooser(JTextArea textArea) {
        setFont(textArea.getFont());
        setMainFrame();
        setSubmitButton(textArea);
        setFontList();
        setStyleList();
        setSizeSlider();
        setSampleTextField();
    }

    private void setMainFrame() {
        mainFrame = new JFrame("Font Chooser");
        mainFrame.setBounds(800, 220, 400, 390);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
    }

    private void setSubmitButton(JTextArea ta) {
        submitButton = new JButton("OK");
        submitButton.setBounds(150, 320, 100, 20);
        mainFrame.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creatNewFont(fontName, fontStyle, fontSize);
                ta.setFont(font);
                mainFrame.dispose();
            }
        });
    }

    private void setFontList() {

        fontLabel = new JLabel("Font:");
        fontLabel.setBounds(20, 10, 100, 20);
        mainFrame.add(fontLabel);

        String[] allFontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Integer array[] = new Integer[allFontNames.length];

        for (int i = 0; i < allFontNames.length; i++) {
            array[i] = i + 1;
        }

        fontList = new JComboBox(array);
        fontList.setSelectedItem(findIndexOfElementOfArray(allFontNames, fontName) + 1);
        fontList.setBounds(20, 40, 200, 20);
        mainFrame.add(fontList);

        //class to setRenderer for fontList
        class ComboBoxRenderar extends JLabel implements ListCellRenderer {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                int offset = (Integer) value - 1;
                String name = allFontNames[offset];
                setText(name);
                setFont(new Font(name, Font.PLAIN, 14));
                return this;
            }
        }

        ComboBoxRenderar renderar = new ComboBoxRenderar();
        fontList.setRenderer(renderar);

        fontList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontName = allFontNames[fontList.getSelectedIndex()];
                creatNewFont(fontName, fontStyle, fontSize);
                sampleTextField.setFont(font);
            }
        });
    }

    private void setStyleList() {
        styleLabel = new JLabel("Style:");
        styleLabel.setBounds(250, 10, 100, 20);
        mainFrame.add(styleLabel);

        String[] allStyleNames = {"Regular", "Bold", "Italic", "Bold Italic"};
        int[] fontStyles = {Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD + Font.ITALIC};

        styleList = new JComboBox(allStyleNames);
        styleList.setBounds(250, 40, 100, 20);
        switch (fontStyle) {
            case 0 ->
                styleList.setSelectedItem("Regular");
            case 1 ->
                styleList.setSelectedItem("Bold");
            case 2 ->
                styleList.setSelectedItem("Italic");
            case 3 ->
                styleList.setSelectedItem("Bold Italic");
        }
        mainFrame.add(styleList);

        styleList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontStyle = fontStyles[styleList.getSelectedIndex()];
                creatNewFont(fontName, fontStyle, fontSize);
                sampleTextField.setFont(font);
            }
        });
    }

    private void setSizeSlider() {
        sizeLabel = new JLabel("Size: ");
        sizeLabel.setBounds(20, 90, 100, 20);
        mainFrame.add(sizeLabel);

        sizeNumber = new JLabel(String.valueOf(fontSize));
        sizeNumber.setBounds(50, 90, 100, 20);
        mainFrame.add(sizeNumber);

        sizeSlider = new JSlider(8, 72, fontSize);
        sizeSlider.setBounds(20, 120, 350, 50);
        mainFrame.add(sizeSlider);
        sizeSlider.setMinorTickSpacing(1);
        sizeSlider.setMajorTickSpacing(8);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);

        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fontSize = sizeSlider.getValue();
                sizeNumber.setText(String.valueOf(fontSize));
                creatNewFont(fontName, fontStyle, fontSize);
                sampleTextField.setFont(font);
            }
        });

    }

    private void setSampleTextField() {
        sampleLabel = new JLabel("Sample:");
        sampleLabel.setBounds(20, 180, 200, 20);
        mainFrame.add(sampleLabel);

        sampleTextField = new JTextField("The quick brown fox jumps over the lazy dog.");
        sampleTextField.setEditable(false);
        sampleTextField.setFont(font);
        sampleTextField.setBounds(20, 210, 350, 100);
        mainFrame.add(sampleTextField);
    }

    private void setFont(Font font) {
        this.font = font;
        this.fontName = font.getName();
        System.out.println(fontName);
        this.fontStyle = font.getStyle();
        this.fontSize = font.getSize();
    }

    private void creatNewFont(String fontName, int fontStyle, int fontSize) {
        this.font = new Font(fontName, fontStyle, fontSize);
    }

    public Font getNewFont() {
        creatNewFont(fontName, fontStyle, fontSize);
        return this.font;
    }

    //function to findIndex of font name in array (for setting font jcombo)
    private int findIndexOfElementOfArray(String[] arr, String ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(ele)) {
                return i;
            }
        }
        return -1;
    }
}
