package ca.utoronto.utm.paint.CommandObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Rectangle{
	
	/**
	 * Creates a default square with no start or end corners.
	 */
	public Square() {
	}
	
	
	/**
	 * Draws the square onto g
	 * @param g The GraphicsContext being drawn on
	 */
	public void execute(GraphicsContext g) {
		int x = this.getStartCorner().getX();
		int y = this.getStartCorner().getY();
		int length = Math.abs(x - this.getEndCorner().getX());
//		g.setStroke(this.colour);
//		g.setFill(this.colour);
//		g.setLineWidth(this.thickness);
		
		if (this.getEndCorner().getX() < x && this.getEndCorner().getY() < y) {
//			if (this.fill) {
			
			if(g.getFill() == Color.TRANSPARENT) {
				g.strokeRect(x - length, y - length, length, length);
			}
			else {
				g.fillRect(x-length, y-length, length, length);
			}
		}
		else if (this.getEndCorner().getX() < x) {
			if (g.getFill() == Color.TRANSPARENT) {
				g.strokeRect(x-length, y, length, length);
			}
			else {
				g.fillRect(x-length, y, length, length);
			}
		}
		else if (this.getEndCorner().getY() < y) {
			if (g.getFill() == Color.TRANSPARENT) {
				g.strokeRect(x, y - length, length, length);
			}
			else {
				g.fillRect(x, y-length, length, length);
			}
		}
		else {
			if (g.getFill() == Color.TRANSPARENT) {
				g.strokeRect(x,y,length,length);
			}
			else {
				g.fillRect(x, y, length, length);
			}
		}
	}

}
