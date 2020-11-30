package ex3;

import javax.swing.*;

public class Window extends JFrame {

    static JTextArea textArea = new JTextArea();
    JMenuBar menuBar = new JMenuBar();
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem newItem = new JMenuItem("New");
    JMenuItem exitItem = new JMenuItem("Exit");
    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem saveAsItem = new JMenuItem("Save as");
    static JFrame frame = new JFrame("Redactor");

    public void createWindow() {
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        setDefaultLookAndFeelDecorated(true);
        createMenu();
        createFile();
    }
    private void createFile(){
        textArea.setBounds(0,0,800,800);
        frame.add(textArea);
    }
    private void createMenu() {
        frame.setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        menu.add(newItem);
        menu.add(openItem);
        menu.addSeparator();
        menu.add(saveItem);
        menu.add(saveAsItem);
        menu.addSeparator();
        menu.add(exitItem);
        openItem.addActionListener(actionEvent -> {
            try {
                new CreateTextDocument().createOpen();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame,"File not found!");
            }
        });
        newItem.addActionListener(actionEvent -> new CreateTextDocument().createNew());
        saveItem.addActionListener(actionEvent -> {
            try {
                new CreateTextDocument().createSave();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Сначала откройте или создайте файл.");
            }
        });
        saveAsItem.addActionListener(actionEvent -> {
            try {
                new CreateTextDocument().createSaveAs();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Сначала откройте или создайте файл.");
            }
        });
        exitItem.addActionListener(actionEvent -> System.exit(0));
    }
}
