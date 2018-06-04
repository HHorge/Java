/**Slightly modified canvas class**/

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.awt.geom.Line2D;

/**
 * <h1>Canvas</h1>
 * This class represents a canvas object that can be drawn to 
 * with various line segments.
 *
 * @author  Stuart Lacy
 * @version 1.0
 * @since   2015-01-19
 */

public class Canvas extends JPanel {

    private int xSize, ySize;
    private List<LS> lines;

//Creates a canvas of chosen size
    public Canvas(int x, int y) {
        xSize = x;
        ySize = y;
        lines = Collections.synchronizedList(new ArrayList<>());
        setupCanvas();
    }

    private void setupCanvas() {

        JFrame frame = new JFrame("Flocking Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.xSize, this.ySize);
    }

    /**
     * <b>NB: You never need to call this method yourself.</b>
     * It handles the drawing but is called automatically each
     * time a line segment is drawn.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Smoother lines
        g2.setStroke(new BasicStroke(3));

        synchronized(lines) {
            for (LS line : lines) {
                g2.setColor(line.getColor());
                g2.draw(new Line2D.Float(line.getStartX(), line.getStartY(), 
                           line.getEndX(), line.getEndY()));
            }
        }
    }

    /**
     * Draws a line between 2 CartesianCoordinates to the canvas.
     *
     * @param startPoint Starting coordinate.
     * @param endPoint Ending coordinate.
     * @param color The colour in which to draw the line, as a String. Accepts the following values:
     *  white, black, blue, cyan, gray, darkgray, lightgray, green, magenta, red, orange, yellow
     * @return Nothing.
     */
    public void drawLineBetweenPoints(CartesianCoordinate startPoint, CartesianCoordinate endPoint, String color) {
        lines.add(new LS(startPoint.getX(), startPoint.getY(), 
                                  endPoint.getX(), endPoint.getY(),
                                  this.parseColour(color)));
    }
    /**
     * Converts a string representing a colour into a Color enumerate attribute.
     *
     * @param colour The desired colour as a string.
     * @return The Color representation of this value.
     */
    private Color parseColour(String colour)
    {
        Color drawColour;

        switch (colour.toLowerCase()) {

            case "white":
                drawColour = Color.WHITE;
                break;
            case "black":
                drawColour = Color.BLACK;
                break;
            case "blue":
                drawColour = Color.BLUE;
                break;
            case "cyan":
                drawColour = Color.CYAN;
                break;
            case "gray":
                drawColour = Color.GRAY;
                break;
            case "darkgray":
                drawColour = Color.DARK_GRAY;
                break;
            case "lightgray":
                drawColour = Color.LIGHT_GRAY;
                break;
            case "green":
                drawColour = Color.GREEN;
                break;
            case "magenta":
                drawColour = Color.MAGENTA;
                break;
            case "red":
                drawColour = Color.RED;
                break;
            case "orange":
                drawColour = Color.ORANGE;
                break;
            case "yellow":
                drawColour = Color.YELLOW;
                break;
            default:
                System.out.println("Unknown colour '" + colour + "', defaulting to black.");
                drawColour = Color.BLACK;
                break;
        }


        return drawColour;
    }

    /**Clears the canvas**/
    public void clear() {
        lines.clear();
    }

    /**
     * <h1>LS</h1>
     * Class to contain x and y starting and ending coordinates 
     * of a line segment.
     *
     * @author Stuart Lacy
     * @version 1.0
     * @since 2014-12-04
     */
    private class LS {
        private int startX, startY, endX, endY;
        private Color color;

        /**
         * Constructor to create a line segment with the specified start
         * and end points.
         *
         * @param startX Initial x-coordinate of the line segment.
         * @param startY Initial y-coordinate of the line segment.
         * @param endX Ending x-coordinate of the line segment.
         * @param endY Ending y-coordinate of the line segment.
         */
        public LS(int startX, int startY, int endX, int endY, Color c) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
            this.color = c;
        }

        /**Returns the initial x-coordinate of the line segment.**/
        public int getStartX() {
            return this.startX;
        }
        /**Gets the draw colour**/
        public Color getColor() {
            return this.color;
        }

        /**Returns the initial y-coordinate of the line segment.**/
        public int getStartY() {
            return this.startY;
        }

        /**Returns the end x-coordinate of the line segment.**/
        public int getEndX() {
            return this.endX;
        }

        /**Returns the end y-coordinate of the line segment.**/
        public int getEndY() {
            return this.endY;
        }
    }
    public void repaintCanvas(){
        repaint();
    }
}
