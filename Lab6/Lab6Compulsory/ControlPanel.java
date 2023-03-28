package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
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
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::loadGame);
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
    private void loadGame(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Load game functionality not implemented yet!");
    }

    private void saveGame(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Save game functionality not implemented yet!");
    }

    private void resetGame(ActionEvent e) {
        int confirmed = JOptionPane.showConfirmDialog(frame, "Are you sure you want to reset the game?", "Reset Game", JOptionPane.YES_NO_OPTION);
        if (confirmed == JOptionPane.YES_OPTION) {
            // TODO: reset the game
            JOptionPane.showMessageDialog(frame, "Game reset!");
        }
    }
}
