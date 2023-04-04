package Homework;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        //create the label for dots and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        //crate the label for lines and the ComboBox
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox<>();
        double[] numberLines = {0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1};
        for (double number : numberLines) {
            linesCombo.addItem(number);
        }

        //create the button for starting the game
        createButton = new JButton("New Game");
        //make the button draw
        createButton.addActionListener(e -> {
            frame.canvas.createBoard();
        });

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);

        add(linesLabel);
        add(linesCombo);

        add(createButton);

    }
}
