package com.gerpan.notepad.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FindAndReplace {

    //class with position of string of other string to set Find function
    //array 'positions' to store all positions of string that need to find in TextArea.
    class Position {

        int startPos, endPos;

        public Position(int startPos, int endPos) {
            this.startPos = startPos;
            this.endPos = endPos;
        }

        public void setPosition(int start, int end) {
            this.startPos = start;
            this.endPos = end;
        }

        public void printPosition() {
            System.out.print(startPos + "-" + endPos);
        }
    }

    //declare variables
    private ArrayList<Position> positions;
    private JFrame mainFrame;
    private JTextField findTextField;
    private JButton findButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton replaceButton;
    private JButton replaceAllButton;
    private String data, dataNeedToFind;
    private int nextWordIndex = 0;
    //end variable declarations

    //constructor
    public FindAndReplace(JTextArea textArea) {
        setGUI();
        setFindAndNextAndPrevButton(textArea);
        setReplaceAndReplaceAllButton(textArea);
    }

    private void setGUI() {

        mainFrame = new JFrame("Find & Replace");
        mainFrame.setVisible(true);
        mainFrame.setBounds(875, 285, 400, 130);
        mainFrame.setLayout(null);

        findTextField = new JTextField();
        findTextField.setBounds(10, 10, 220, 30);
        setStatusForFindButton();
        mainFrame.add(findTextField);

        findButton = new JButton("Find");
        findButton.setBounds(10, 50, 60, 30);
        findButton.setEnabled(false);
        mainFrame.add(findButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(90, 50, 60, 30);
        nextButton.setEnabled(false);
        mainFrame.add(nextButton);

        prevButton = new JButton("Prev");
        prevButton.setBounds(170, 50, 60, 30);
        prevButton.setEnabled(false);
        mainFrame.add(prevButton);

        replaceButton = new JButton("Replace");
        replaceButton.setBounds(250, 10, 120, 30);
        replaceButton.setEnabled(false);
        mainFrame.add(replaceButton);

        replaceAllButton = new JButton("Replace all");
        replaceAllButton.setBounds(250, 50, 120, 30);
        replaceAllButton.setEnabled(false);
        mainFrame.add(replaceAllButton);
    }

    private void getPositionToArray() {
        positions = new ArrayList<>();
        int i = 0, start = 0, end = 0;
        String subData = data;
        while (i < data.length()) {
            if (!subData.contains(dataNeedToFind)) {
                break;
            }
            start = subData.indexOf(dataNeedToFind) + i;
            end = start + dataNeedToFind.length();
            positions.add(new Position(start, end));
            i = end;
            subData = data.substring(i);
        }
    }

    private void setSelectionToTextArea(JTextArea textArea, int wordIndex) {

        int startIndex = positions.get(wordIndex).startPos;
        int endIndex = positions.get(wordIndex).endPos;
        textArea.setSelectionStart(startIndex);
        textArea.setSelectionEnd(endIndex);
    }

    private void setFindAndNextAndPrevButton(JTextArea textArea) {

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == findButton) {
                    data = textArea.getText();
                    dataNeedToFind = findTextField.getText();
                    if (!data.contains(dataNeedToFind)) {
                        JOptionPane.showMessageDialog(mainFrame, "Not found!");
                        disableRestButton();
                    }
                    getPositionToArray();
                    nextWordIndex = 0;
                    setSelectionToTextArea(textArea, nextWordIndex);
                    enableRestButton();
                }
                if (e.getSource() == nextButton) {
                    if (nextWordIndex < positions.size() - 1) {
                        nextWordIndex++;
                        setSelectionToTextArea(textArea, nextWordIndex);
                    }
                }
                if (e.getSource() == prevButton) {
                    if (nextWordIndex > 0) {
                        nextWordIndex--;
                        setSelectionToTextArea(textArea, nextWordIndex);
                    }
                }
            }
        };
        findButton.addActionListener(act);
        nextButton.addActionListener(act);
        prevButton.addActionListener(act);
    }

    private void setReplaceAndReplaceAllButton(JTextArea textArea) {

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == replaceButton) {
                    String dataNeedToReplace = JOptionPane.showInputDialog(mainFrame, "Enter string to replace", "Replace", JOptionPane.PLAIN_MESSAGE);
                    textArea.replaceSelection(dataNeedToReplace);
                }
                if (e.getSource() == replaceAllButton) {
                    String dataNeedToReplace = JOptionPane.showInputDialog(mainFrame, "Enter string to replace", "Replace", JOptionPane.PLAIN_MESSAGE);
                    data = data.replaceAll(dataNeedToFind, dataNeedToReplace);
                    dataNeedToFind = dataNeedToReplace;
                    findTextField.setText(dataNeedToFind);
                    textArea.setText(data);
                }
            }

        };

        replaceButton.addActionListener(act);
        replaceAllButton.addActionListener(act);

    }

    private void setStatusForFindButton() {
        findTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (findTextField.getText().length() != 0) {
                    findButton.setEnabled(true);
                } else {
                    findButton.setEnabled(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (findTextField.getText().length() != 0) {
                    findButton.setEnabled(true);
                } else {
                    findButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (findTextField.getText().length() != 0) {
                    findButton.setEnabled(true);
                } else {
                    findButton.setEnabled(false);
                }
            }
        });
    }

    private void disableRestButton() {
        nextButton.setEnabled(false);
        prevButton.setEnabled(false);
        replaceButton.setEnabled(false);
        replaceAllButton.setEnabled(false);
    }

    private void enableRestButton() {
        nextButton.setEnabled(true);
        prevButton.setEnabled(true);
        replaceButton.setEnabled(true);
        replaceAllButton.setEnabled(true);
    }
}
