package ca.utoronto.utm.paint.CommandObjects;

import javafx.scene.canvas.GraphicsContext;

public abstract class DrawingCommand {
	
	protected String type;
	
	
	/**
	 * Constructor for DrawingCommand objects. Sets type to "option" by default
	 */
	public DrawingCommand() {
		this.type = "option";
	}
	
	/**
	 * Performs a set of actions on a DrawingCommand object in order to display it on g
	 * @param g the GraphicsContext execute is performed on
	 */
	public abstract void execute(GraphicsContext g);
	
	public String getType() {
		return this.type;
	}
}

