package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.ColourCommand;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ColourManipulatorStrategy extends ManipulatorStrategy {
	
	/**
	 * Creates a ColourManipulatorStrategy and sets the drawing command to a new colour command using parameter colour
	 * @param view
	 * @param colour the new colour of the ColourCommand
	 */
	public ColourManipulatorStrategy(View view, Color colour) {
		super(view);
		this.setDrawingCommand(new ColourCommand());
		((ColourCommand) this.drawingCommand).setColour(colour);
		this.addCommandToModel();
	}

	public void clickEventHandler(MouseEvent event) {
		return;
	}
}
