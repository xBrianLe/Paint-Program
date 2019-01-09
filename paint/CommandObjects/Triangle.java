package ca.utoronto.utm.paint.CommandObjects;

import java.util.ArrayList;

import ca.utoronto.utm.paint.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangle extends Shape {
	
	
	boolean start = true;
	
	private ArrayList<Point> pointarray = new ArrayList<Point>();

	
	/**
	 * Creates a default Triangle with no points.
	 */
	public Triangle() {
		
	}
	
	
	public void addPoint(Point p){
		this.pointarray.add(p);
	}
	
	public int getSize(){
		return this.pointarray.size();
	}
	
	public void removepreviouspoints(){
		this.pointarray.remove(this.pointarray.size() - 1);
		
	}
	
	public void setStart(Boolean x) {
		this.start = x;
	}
	
	/**
	 * Draws the Triangle onto g
	 * @param g The GraphicsContext being drawn on
	 */
	public void execute(GraphicsContext g) {

		if(this.getSize() == 2){
			Point p1 = pointarray.get(0);
			Point p2 = pointarray.get(1);
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

		}

		else if(this.getSize() >= 3){
			
			Point p1 = pointarray.get(0);
			Point p2 = pointarray.get(1);
			Point p3 = pointarray.get(2);

			if(g.getFill() == Color.TRANSPARENT) {
				g.strokePolygon(new double [] { (double)p1.getX(), 
				(double)p2.getX(), (double)p3.getX()},
				new double [] {(double)p1.getY(), (double)p2.getY(), 
				(double)p3.getY()}, 3);
			} else {
				g.fillPolygon(new double [] { (double)p1.getX(), 
				(double)p2.getX(), (double)p3.getX()},
				new double [] {(double)p1.getY(), (double)p2.getY(), 
				(double)p3.getY()}, 3);

			}
		}
	}
}