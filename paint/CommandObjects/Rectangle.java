package ca.utoronto.utm.paint.CommandObjects;

import ca.utoronto.utm.paint.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Rectangle extends Shape{
		
		private Point startCorner;
		private Point endCorner;
		
		
		/**
		 * Creates a default rectangle with no start or end corners.
		 */
		public Rectangle() {
			
		}
		
		
		public Point getStartCorner() {
			return this.startCorner;
		}
		
		public Point getEndCorner() {
			return this.endCorner;
		}
		
		public void setStartCorner(Point x) {
			this.startCorner = x;
		}
		
		public void setEndCorner(Point x) {
			this.endCorner = x;
		}
		
		/**
		 * Draws the Rectangle on g
		 * @param g The GraphicsContext being drawn on
		 */
		public void execute(GraphicsContext g) {
			int x = this.getStartCorner().getX();
			int y = this.getStartCorner().getY();
			int width = Math.abs(x - this.getEndCorner().getX());
			int height = Math.abs(y - this.getEndCorner().getY());
//			g.setStroke(this.colour);
//			g.setFill(this.colour);
//			g.setLineWidth(this.thickness);
			
			if (this.getEndCorner().getX() < x && this.getEndCorner().getY() < y) {
				if (g.getFill() != Color.TRANSPARENT) {
					g.fillRect(x - width, y - height, width, height);
				}
				else {
					g.strokeRect(x-width, y-height, width, height);
				}
			}
			else if (this.getEndCorner().getX() < x) {
				if (g.getFill() != Color.TRANSPARENT) {
					g.fillRect(x-width, y, width, height);
				}
				else {
					g.strokeRect(x-width, y, width, height);
				}
			}
			else if (this.getEndCorner().getY() < y) {
				if (g.getFill() != Color.TRANSPARENT) {
					g.fillRect(x, y - height, width, height);
				}
				else {
					g.strokeRect(x, y-height, width, height);
				}
			}
			else {
				if (g.getFill() != Color.TRANSPARENT) {
					g.fillRect(x,y,width,height);
				}
				else {
					g.strokeRect(x, y, width, height);
				}
			}
		}
		
	}