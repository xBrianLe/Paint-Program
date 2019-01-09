package ca.utoronto.utm.paint.CommandObjects;

import javafx.scene.canvas.GraphicsContext;

public class Polyline extends Squiggle{
	
	private Boolean startflag = true;
	
	/**
	 * Creates a default polyline with no points.
	 */
	public Polyline() {
		super();
	}
	
	
	public void removeLatestPoint() {
		this.points.remove(this.points.size()-1);
	}
	
	
	@Override
	/**
	 * Draws the polyline onto the GraphicsContext g
	 * @param g the GraphicsContext being drwawn on
	 */
	public void execute(GraphicsContext g) {
		if (points.size() > 1) {
			for (int i = 1; i < points.size(); i++) {
				g.strokeLine(this.points.get(i - 1).getX(), this.points.get(i-1).getY(),
						this.points.get(i).getX(), this.points.get(i).getY());
			}
	
		}
	}
	
	public Boolean getStartFlag() {
		return startflag;
	}
	public void setStartFlag(boolean b) {
		this.startflag = b;
		
	}
}