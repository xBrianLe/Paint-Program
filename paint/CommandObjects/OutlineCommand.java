package ca.utoronto.utm.paint.CommandObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class OutlineCommand extends DrawingCommand{
	
	public OutlineCommand() {}
	
	/**
	 * Sets the fill colour of g to transparent.
	 */
	public void execute(GraphicsContext g) {
		
		
		if (g.getFill() != Color.TRANSPARENT) {
			g.setStroke(g.getFill());
		}
		g.setFill(Color.TRANSPARENT);
	}

}
