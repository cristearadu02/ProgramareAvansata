package Homework;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel implements Serializable{
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    List<Line> availabeLines = new ArrayList<>();
    List<Dot> dots = new ArrayList<>();
    Dot source = null;
    Dot destination = null;
    int color = 0;


   @JsonCreator
    public DrawingPanel(@JsonProperty("dots") List<Dot> dots, @JsonProperty("lines") List<Line> lines,
                        @JsonProperty("source") Dot source, @JsonProperty("destination") Dot destination,
                        @JsonProperty("color") int color, @JsonProperty("frame") MainFrame frame, @JsonProperty("x") int[] x, @JsonProperty("y") int[] y,
                        @JsonProperty("numVertices") int numVertices, @JsonProperty("edgeProbability") double edgeProbability) {
                                this.dots = dots;
                                this.source = source;
                                this.destination = destination;
                                this.color = color;
                                this.frame = frame;
                                this.availabeLines = lines;
                                this.x = x;
                                this.y = y;
                                this.numVertices = numVertices;
                                this.edgeProbability = edgeProbability;
                                createOffscreenImage();
                                initPanel();
                            }


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        availabeLines.clear();
        dots.clear();
        createOffscreenImage();
        initPanel();
        createBoard();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                repaint();
            }
        });
    }
    private void createOffscreenImage() {

        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard() {

        color = 0;
        dots.clear();
        availabeLines.clear();
        source = null;
        destination = null;

        Player player1 = new Player("Ion");
        Player player2 = new Player("Maria");

        this.removeMouseListener(this.getMouseListeners()[0]);
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();

        System.out.println(numVertices + " " + edgeProbability);

        createOffscreenImage();
        createVertices();
        drawVertices();
        drawLines();

        repaint();

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getClickCount() == 1)
               {int xClick = e.getX();
                int yClick = e.getY();

                System.out.println("You clicked on: " + xClick + " " + yClick);

                   if (color % 2 == 0)
                       graphics.setColor(Color.BLUE);
                   else
                       graphics.setColor(Color.RED);

                if(source==null) {
                    for (Dot dot : dots) {
                        if ((xClick >= dot.getX() - 10 && xClick <= dot.getX() + 10) && (yClick >= dot.getY() - 10 && yClick <= dot.getY() + 10)) {
                            source = dot;
                            graphics.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);
                            repaint();
                        }
                    }
                }

                   if(source!=null && destination==null) {
                       for (Dot dot : dots) {
                           if ((xClick >= dot.getX() - 10 && xClick <= dot.getX() + 10) && (yClick >= dot.getY() - 10 && yClick <= dot.getY() + 10) && dot != source) {
                               destination = dot;
                               graphics.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);
                               repaint();
                           }
                       }
                   }

                if(source!=null && destination!=null)
                {   Line lineToRemove = null;
                    for(Line line : availabeLines)
                    {
                        if((line.getStart()==source && line.getEnd()==destination) || (line.getStart()==destination && line.getEnd()==source))
                        {
                            graphics.drawLine(source.getX(), source.getY(), destination.getX(), destination.getY());
                            if(color % 2 == 0)
                                player1.addLine(line);
                            else
                                player2.addLine(line);
                            lineToRemove = line;
                            repaint();
                            break;
                        }
                    }
                    availabeLines.remove(lineToRemove);
                    source = null;
                    destination = null;
                    if(player1.checkWin())
                    {
                        System.out.println("A castigat 1");
                        int confirmed = JOptionPane.showConfirmDialog(frame, "Player 1 wins! New game?", "End Game", JOptionPane.YES_NO_OPTION);
                        if (confirmed == JOptionPane.NO_OPTION) {
                            frame.dispose();
                        }
                        else
                        {
                            frame.canvas.createBoard();
                        }
                    }
                    if(player2.checkWin())
                    {
                        System.out.println("A castigat 2");
                        int confirmed = JOptionPane.showConfirmDialog(frame, "Player 2 wins! New game?", "End Game", JOptionPane.YES_NO_OPTION);
                        if (confirmed == JOptionPane.NO_OPTION) {
                            frame.dispose();
                        }
                        else
                        {
                            frame.canvas.createBoard();
                        }
                    }
                    color++;
                }

            }
            }
        };

        this.addMouseListener(ml);
    }

    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            dots.add(new Dot(x[i], y[i]));
        }
    }
    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }
    private void drawLines() {
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if(i!=j) {
                  if (random.nextDouble() <= edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                    availabeLines.add(new Line(dots.get(i), dots.get(j)));
                  }
                }
            }
        }
    }

    @Override
    public void update(Graphics g) {

    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

        public List<Dot> getDots() {
            return dots;
        }

        public static int getH() {
            return H;
        }

        public double getEdgeProbability() {
            return edgeProbability;
        }

        public int getNumVertices() {
            return numVertices;
        }

        public static int getW() {
            return W;
        }

        public MainFrame getFrame() {
            return frame;
        }

        public BufferedImage getImage() {
            return image;
        }

        public Dot getDestination() {
            return destination;
        }

        public Dot getSource() {
            return source;
        }

        public int getColor() {
            return color;
        }

        public List<Line> getAvailabeLines() {
            return availabeLines;
        }

}



