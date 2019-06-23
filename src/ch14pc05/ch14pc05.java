package ch14pc05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Applet to draw a polygon
 * @author frank
 */
public class ch14pc05 extends JApplet implements MouseListener, MouseMotionListener {
    // Variables
    int numberOfClicks;
    int[] xCoordinates, yCoordinates;
    
    
    public void init() {
        // Set the values for numberOfClicks and instantiate the arrays
        numberOfClicks = 0;
        xCoordinates = new int[6];
        yCoordinates = new int[6];
        
        getContentPane().setBackground(Color.WHITE);
        addMouseListener(this);
    }
    
    /**
     * 
     * @param g 
     */
    public void paint(Graphics g) {
        // Call the super class to paint
        super.paint(g);
        
        // Set the color
        g.setColor(Color.ORANGE);
        
        // Fill the polygon once six clicks have been made
        if (numberOfClicks == 6) {
            g.fillPolygon(xCoordinates, yCoordinates, 6);
        }
        
        
    }
    
    /**
     * Mouse Click to establish the points of the polygon
     * @param e MouseEvent The mouse event when the mouse button is clicked
     */
    public void mouseClicked(MouseEvent e) {
        
        // Reset the number of clicks once it reaches 6
        if (numberOfClicks == 6) {
            numberOfClicks = 0;
        }
        
        xCoordinates[numberOfClicks] = e.getX();
        yCoordinates[numberOfClicks] = e.getY();
        numberOfClicks++;
        
        if (numberOfClicks == 6) {
            repaint();
        }
    }
    
    // Non-applicable mouse motion listeners
    public void mouseReleased(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}