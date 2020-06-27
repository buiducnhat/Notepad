package com.gerpan.notepad;

import com.gerpan.notepad.util.FindAndReplace;
import com.gerpan.notepad.util.JFontChooser;
import com.gerpan.notepad.util.WordCounter;
import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.*;

public class Notepad extends javax.swing.JFrame {

    public Notepad() {
        initComponents();
    }

    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newItem = new javax.swing.JMenuItem();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        saveAsItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        copyItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        findAndReplaceItem = new javax.swing.JMenuItem();
        selectAllItem = new javax.swing.JMenuItem();
        formatMenu = new javax.swing.JMenu();
        wordWrapItem = new javax.swing.JCheckBoxMenuItem();
        fontItem = new javax.swing.JMenuItem();
        colorMenu = new javax.swing.JMenu();
        textColorItem = new javax.swing.JMenuItem();
        backgroundColorItem = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        wordCountterItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("United - Notepad");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 220));
        setName("mainFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        textArea.setRows(5);
        textArea.setTabSize(4);
        scrollPane.setViewportView(textArea);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");

        newItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newItem.setMnemonic('N');
        newItem.setText("New");
        newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newItemActionPerformed(evt);
            }
        });
        fileMenu.add(newItem);

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openItem.setMnemonic('O');
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        fileMenu.add(openItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveItem.setMnemonic('S');
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveItem);

        saveAsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveAsItem.setMnemonic('A');
        saveAsItem.setText("Save as");
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitItem.setMnemonic('E');
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edit");

        copyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copyItem.setMnemonic('O');
        copyItem.setText("Copy");
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });
        editMenu.add(copyItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutItem.setMnemonic('U');
        cutItem.setText("Cut");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        editMenu.add(cutItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pasteItem.setMnemonic('P');
        pasteItem.setText("Paste");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteItem);

        findAndReplaceItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        findAndReplaceItem.setMnemonic('F');
        findAndReplaceItem.setText("Find & Replace");
        findAndReplaceItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findAndReplaceItemActionPerformed(evt);
            }
        });
        editMenu.add(findAndReplaceItem);

        selectAllItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectAllItem.setMnemonic('S');
        selectAllItem.setText("Select All");
        selectAllItem.setToolTipText("");
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });
        editMenu.add(selectAllItem);

        menuBar.add(editMenu);

        formatMenu.setMnemonic('O');
        formatMenu.setText("Format");

        wordWrapItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W,
                java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        wordWrapItem.setMnemonic('W');
        wordWrapItem.setText("Word Wrap");
        wordWrapItem.setToolTipText("");
        wordWrapItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordWrapItemActionPerformed(evt);
            }
        });
        formatMenu.add(wordWrapItem);

        fontItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F,
                java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        fontItem.setMnemonic('F');
        fontItem.setText("Font");
        fontItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontItemActionPerformed(evt);
            }
        });
        formatMenu.add(fontItem);

        colorMenu.setMnemonic('C');
        colorMenu.setText("Color");

        textColorItem.setMnemonic('T');
        textColorItem.setText("Text Color");
        textColorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textColorItemActionPerformed(evt);
            }
        });
        colorMenu.add(textColorItem);

        backgroundColorItem.setMnemonic('B');
        backgroundColorItem.setText("Background Color");
        backgroundColorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backgroundColorItemActionPerformed(evt);
            }
        });
        colorMenu.add(backgroundColorItem);

        formatMenu.add(colorMenu);

        menuBar.add(formatMenu);

        toolsMenu.setMnemonic('T');
        toolsMenu.setText("Tools");

        wordCountterItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
                java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        wordCountterItem.setMnemonic('W');
        wordCountterItem.setText("Word Counter");
        wordCountterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordCountterItemActionPerformed(evt);
            }
        });
        toolsMenu.add(wordCountterItem);

        menuBar.add(toolsMenu);

        helpMenu.setMnemonic('H');
        helpMenu.setText("Help");

        aboutItem.setMnemonic('A');
        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700,
                Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE));

        pack();
    }

    // file Menu code.
    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openItemActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))) {
                    String data = "", temp = "";
                    while ((temp = in.readLine()) != null) {
                        data += "\n" + temp;
                    }
                    if (data.charAt(data.length() - 1) == '\n') {
                        data = data.substring(0, data.length() - 1);
                    }
                    if (data.charAt(0) == '\n') {
                        data = data.substring(1);
                    }
                    textArea.setText(data);
                    curTextData = data;
                    isSaved = true;
                    this.setTitle(file.getName() + " - Notepad");
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }// GEN-LAST:event_openItemActionPerformed

    private void newItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newItemActionPerformed
        isChanged = !textArea.getText().equals(curTextData);
        if (isChanged) {
            int selection = JOptionPane.showConfirmDialog(this, "Do you want to save this file?");
            if (selection == JOptionPane.YES_OPTION) {
                if (isSaved) {
                    saveItem.doClick();
                } else {
                    saveAsItem.doClick();
                }
            } else if (selection == JOptionPane.NO_OPTION) {
                textArea.setText("");
                curTextData = "";
                this.setTitle("United - Notepad");
            }
            isSaved = false;
        } else {
            textArea.setText("");
            curTextData = "";
            this.setTitle("United - Notepad");
        }

    }// GEN-LAST:event_newItemActionPerformed

    private void saveAsItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveAsItemActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            try {
                try (BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(file), "UTF8"))) {
                    writer.write(textArea.getText());
                }
                isSaved = true;
                this.setTitle(file.getName() + " - Notepad");
                curTextData = textArea.getText();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }// GEN-LAST:event_saveAsItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveItemActionPerformed
        if (!isSaved) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
            }
        }
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
            writer.write(textArea.getText());
            writer.close();
            isSaved = true;
            curTextData = textArea.getText();
            this.setTitle(file.getName() + " - Notepad");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_saveItemActionPerformed

    private void copyItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_copyItemActionPerformed
        textArea.copy();
    }// GEN-LAST:event_copyItemActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cutItemActionPerformed
        textArea.cut();
    }// GEN-LAST:event_cutItemActionPerformed

    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pasteItemActionPerformed
        textArea.paste();
    }// GEN-LAST:event_pasteItemActionPerformed

    private void selectAllItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selectAllItemActionPerformed
        textArea.selectAll();
    }// GEN-LAST:event_selectAllItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitItemActionPerformed
        isChanged = !textArea.getText().equals(curTextData);
        if (isChanged) {
            int selection = JOptionPane.showConfirmDialog(this, "Do you want to save this file?");
            if (selection == JOptionPane.YES_OPTION) {
                if (isSaved) {
                    saveItem.doClick();
                    System.exit(0);
                } else {
                    saveAsItem.doClick();
                    System.exit(0);
                }
            } else if (selection == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }// GEN-LAST:event_exitItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
        exitItem.doClick();
    }// GEN-LAST:event_formWindowClosing

    private void findAndReplaceItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_findAndReplaceItemActionPerformed
        FindAndReplace findAndReplace = new FindAndReplace(textArea);
    }// GEN-LAST:event_findAndReplaceItemActionPerformed

    private void wordWrapItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_wordWrapItemActionPerformed
        if (wordWrapItem.getState()) {
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        } else {
            textArea.setLineWrap(false);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        }
    }// GEN-LAST:event_wordWrapItemActionPerformed

    private void fontItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_fontItemActionPerformed
        JFontChooser fontChooser = new JFontChooser(textArea);
        textArea.setFont(fontChooser.getNewFont());
    }// GEN-LAST:event_fontItemActionPerformed

    private void textColorItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textColorItemActionPerformed
        Color color = JColorChooser.showDialog(this, "Select color", Color.BLACK);
        textArea.setForeground(color);
    }// GEN-LAST:event_textColorItemActionPerformed

    private void backgroundColorItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backgroundColorItemActionPerformed
        Color color = JColorChooser.showDialog(this, "Select color", Color.BLACK);
        textArea.setBackground(color);
    }// GEN-LAST:event_backgroundColorItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_aboutItemActionPerformed
        String data = "Notepad - made from Java Swing\nBy Gerpan - HUST\n\nContact:\nwww.facebook.com/nhat.4701\n\t\tnhaths4701@gmail.com";
        JOptionPane.showMessageDialog(this, data, "About", JOptionPane.PLAIN_MESSAGE);
    }// GEN-LAST:event_aboutItemActionPerformed

    private void wordCountterItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_wordCountterItemActionPerformed
        WordCounter wc = new WordCounter(textArea.getText());
        String message = "Character: " + wc.getCharCount() + "\n" + "Word: " + wc.getWordCount() + "\n" + "Sentence: "
                + wc.getSenCount();
        JOptionPane.showMessageDialog(this, message, "Word Counter", JOptionPane.PLAIN_MESSAGE);
    }// GEN-LAST:event_wordCountterItemActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetalLookAndFeels");
        } catch (Exception ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Notepad().setVisible(true);

            }
        });
    }

    // declare custom variable
    private File file;
    private boolean isChanged, isSaved = false;
    private String curTextData = "";
    // end custom variable declaration

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenuItem backgroundColorItem;
    private javax.swing.JMenu colorMenu;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem findAndReplaceItem;
    private javax.swing.JMenuItem fontItem;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newItem;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JMenuItem saveAsItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JMenuItem selectAllItem;
    private javax.swing.JTextArea textArea;
    private javax.swing.JMenuItem textColorItem;
    private javax.swing.JMenu toolsMenu;
    private javax.swing.JMenuItem wordCountterItem;
    private javax.swing.JCheckBoxMenuItem wordWrapItem;
    // End of variables declaration//GEN-END:variables
}
