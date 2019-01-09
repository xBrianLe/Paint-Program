package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

public class Point {
	int x, y;
	Color colour;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
		

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
