package Homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    // JButton saveCurrentBtn = new JButton("Save game");
    JButton saveBtn = new JButton("Save PNG");
    JButton exitBtn = new JButton("Exit");
    JButton resetBtn = new JButton("Reset");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(loadBtn);
       // add(saveCurrentBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::loadGame);
        //saveCurrentBtn.addActionListener(this::saveCurrentGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }
    private void exitGame(ActionEvent e) {
        int confirmed = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the game?", "Exit Game", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            frame.dispose();
        }
    }

    private void saveCurrentGame(ActionEvent e)
    {
        //save game using serialization and jackson
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int option = fileChooser.showSaveDialog(frame);
            File file = fileChooser.getSelectedFile();
            try {
                AccessibleAWTComponent.class.getDeclaredMethod("getAccessibleParent").setAccessible(true);
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(ex);
            }
             SaveDrawingPanel.save(this.frame.canvas, file.getAbsolutePath());
    }
    private void saveGame(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        File file = fileChooser.getSelectedFile();
        try {
            ImageIO.write(frame.canvas.image, "PNG", file);
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void loadGame(ActionEvent e) {

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int option = fileChooser.showOpenDialog(frame);
            File file = fileChooser.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            BufferedImage image = ImageIO.read(fis);
            frame.canvas.image = image;
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void resetGame(ActionEvent e) {
        int confirmed = JOptionPane.showConfirmDialog(frame, "Are you sure you want to reset the game?", "Reset Game", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            // TODO: reset the drawing panel
            frame.canvas.createBoard();
            JOptionPane.showMessageDialog(frame, "Game reset!");
        }
    }
}
