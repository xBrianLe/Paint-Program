package ca.utoronto.utm.paint.CommandObjects;

import ca.utoronto.utm.paint.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Eraser extends Squiggle {
	
	
	/**
	 * Creates a default eraser with no points.
	 */
	public Eraser () {
	}
		
	
	@Override
	/**
	 *  Draws the eraser on to g
	 *  @param g the GraphicsContext that is being drawn on
	 */
	public void execute(GraphicsContext g) {
		Color wh = (Color) g.getStroke();

		for (int i = 0; i < this.points.size() - 1; i++) {
			g.setStroke(Color.WHITE);
			Point p1 = this.points.get(i);
			Point p2 = this.points.get(i + 1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());	
			}
		
		g.setStroke(wh);
		g.setLineWidth(g.getLineWidth());
		}
	
	
}
