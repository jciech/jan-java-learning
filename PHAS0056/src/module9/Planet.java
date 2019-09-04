package module9;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JPanel;

public class Planet extends JPanel implements ActionListener {

	// Variables defining each planet. Will assume their graphical size is
	// proportional to mass
	// The constructor for the planet will take these
	double mass, rPos;

	public Planet(double mass, double distanceFromCentre) {
		this.mass = mass;
		this.rPos = distanceFromCentre;
	}

	// Defining all variables which will be used explicitly in drawing the orbit
	double xPos, yPos, radiusX, radiusY, theta;

	// Defining all variables to actually create an animation
	private Timer animationTimer;
	private final int delay = 50; 
	private final double delta = 0.005;

	// We must create a method to draw the representation of our orbit
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	}
	
	
	// Defined method to draw a circle at a point which will be utilised in the paintComponent method
	public void drawCenteredCircle(Graphics2D g, int x, int y, int r1, int r2, int r) {
		  x = x-(r1/2);
		  y = y-(r2/2);
		  g.fillOval(x,y,r,r);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
