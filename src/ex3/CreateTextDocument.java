package ex3;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CreateTextDocument implements ICreateDocument {
    static File file;
    FileReader fileReader;
    FileWriter fileWriter;
    JFileChooser fileChooser = new JFileChooser();

    @Override
    public IDocument createNew() {
        return new IDocument() {
        };
    }

    public void createSave() throws Exception {
        fileWriter = new FileWriter(file, false);
        fileWriter.write(Window.textArea.getText());
        fileWriter.close();
    }

    public void createSaveAs() throws Exception {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if(fileChooser.showSaveDialog(Window.frame) == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            createSave();
        }

    }

    @Override
    public IDocument createOpen() throws IOException {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text","txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(fileChooser.showOpenDialog(Window.frame) == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            if(file.canRead()){
                Window.textArea.setText("");
                fileReader = new FileReader(file);
                Scanner scan = new Scanner(fileReader);
                while(scan.hasNextLine()){
                    Window.textArea.setText(Window.textArea.getText() + scan.nextLine());
                }
                fileReader.close();
                Window.frame.setTitle(file.getName());
            } else {
                JOptionPane.showMessageDialog(Window.frame, "Нечитаемый файл");
            }
        } else {
            JOptionPane.showMessageDialog(Window.frame, "Файл не был корректно выбран");
        }
        return null;
    }
}
