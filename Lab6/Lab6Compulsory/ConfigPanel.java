package Compulsory;

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
        Integer[] possibleValues = new Integer[(Integer) dotsSpinner.getValue()];

        //create the button for starting the game
        createButton = new JButton("New Game");

        for(int i = possibleValues.length-1; i>=0; i--)
            possibleValues[i] = i;

        linesCombo = new JComboBox(possibleValues);

        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);

        add(linesLabel);
        add(linesCombo);

        add(createButton);

    }
}
