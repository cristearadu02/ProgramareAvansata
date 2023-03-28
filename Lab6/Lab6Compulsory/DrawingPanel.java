package Compulsory;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        //get the number of dots (numVertices)
        //get the probability that two dots form a line (edgeProbability)
        //draw the board, that is:
        //compute the coordinates of the dots
        //draw the dots
        //draw the lines
        super.paintComponent(g);

        int numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        int numLines = (Integer) frame.configPanel.linesCombo.getSelectedItem();

        //compute the coordinates of the dots
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 10;
        double alpha = 2 * Math.PI / numVertices;
        int[] x = new int[numVertices];
        int[] y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }

        //draw the dots
        g.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            g.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }

        //draw the lines
        int cont = 0;
        g.setColor(Color.BLACK);
        for (int i = 0; i < numVertices-1; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                // if(cont<numLines)
                // {
                    g.drawLine(x[i], y[i], x[j], y[j]);
                //    cont++;
                //   }
                //  else
                //    break;
            }
        }
    }
}
