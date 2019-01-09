package ca.utoronto.utm.paint.CommandObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FillCommand extends DrawingCommand {
	
	
	public FillCommand() {}
	
	/**
	 * Sets the fill value of g to the current stroke colour.
	 * @param g the GraphicsContext who's fill value is being changed
	 */
	public void execute(GraphicsContext g) {
		
		g.setFill(g.getStroke());
	}
}
