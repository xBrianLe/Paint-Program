package ca.utoronto.utm.paint.CommandObjects;
import ca.utoronto.utm.paint.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;

public class Circle extends Shape{
	
	private Point centre;
	private int radius;
	
	
	/**
	 * Creates a default Circle object, with no centre or radius.
	 */
	public Circle() {
		
	}
		
	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * Draws the circle on the GraphicsContext g 
	 * @param g GraphicsContext we are performing the executions on
	 */
	public void execute(GraphicsContext g) {
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		
		if(g.getFill() == Color.TRANSPARENT) {
			g.strokeOval(x-radius, y-radius, 2*radius, 2*radius);
		} else {
			g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		}
	}
}
	
	
