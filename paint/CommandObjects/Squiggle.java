package ca.utoronto.utm.paint.CommandObjects;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Squiggle extends Shape {
	

	protected ArrayList<Point> points = new ArrayList<Point>();

	/**
	 * Creates a default squiggle with no points.
	 */
	public Squiggle() {}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}

	@Override
	/**
	 * Draws the squiggle onto g
	 * @paramter g the Graphics Context
	 */
	public void execute(GraphicsContext g) {
		for (int i = 0; i < this.points.size() - 1; i++) {
//			g.setStroke(this.colour);
//			g.setLineWidth(this.thickness);
			Point p1 = this.points.get(i);
			Point p2 = this.points.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			
		}
	}
}
