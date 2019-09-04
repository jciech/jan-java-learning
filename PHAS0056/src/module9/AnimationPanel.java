package module9;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class AnimationPanel extends JPanel implements ActionListener {

	private final long delay = 50; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate

	AnimationPanel(int width, int height, double rotationTime) {
		    setPreferredSize(new Dimension(width,height));
		    int size = Math.min(width, height) / 4;

		    delta = 2*Math.PI*delay/(rotationTime*1000);
		    animationTimer = new Timer();
			animationTimer.schedule(createAndDisplayGui(), delay);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	}
}
