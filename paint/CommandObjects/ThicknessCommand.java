package ca.utoronto.utm.paint.CommandObjects;
//Concrete Method

import javafx.scene.canvas.GraphicsContext;

public class ThicknessCommand extends DrawingCommand{
	
	private int thickness;

	public ThicknessCommand() {}
	
	public void setThickness(double thick) {
		this.thickness = (int) thick;
	}
	
	/**
	 * Sets the line width of g to the thickness given from the strategy
	 * @param g the GraphicsContext being modified
	 */
	public void execute(GraphicsContext g) {
		g.setLineWidth(this.thickness);
		
	}

}
