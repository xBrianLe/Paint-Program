package ca.utoronto.utm.paint.CommandObjects;
import javafx.scene.canvas.GraphicsContext;
//Concrete method
import javafx.scene.paint.Color;

public class ColourCommand extends DrawingCommand {
	
	private Color colour;
	
	public ColourCommand() {}
	

	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	/**
	 * Performs execute on the colour command which results in changing the stroke colour to this.colour
	 * on the GraphicsContext g
	 * @param g the GraphicsContext execute is being performed on
	 */
	public void execute(GraphicsContext g) {
		if(g.getFill() == Color.TRANSPARENT) {
			g.setStroke(colour);
		}
		else {
			g.setFill(colour);
			g.setStroke(colour);
		}
	}
}
