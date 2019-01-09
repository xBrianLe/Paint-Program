package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.ThicknessCommand;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ThicknessManipulatorStrategy extends ManipulatorStrategy {
	
	/**
	 * Creates a new ThicknessManipulatorStrategy which creates the Thickness command and adds the event
	 * to the command stack
	 * @param view
	 * @param thickness user's desired thickness
	 */
	public ThicknessManipulatorStrategy(View view, Double thickness) {
		super(view);
		this.setDrawingCommand(new ThicknessCommand());
		((ThicknessCommand) this.drawingCommand).setThickness(thickness);
		this.addCommandToModel();
	}

	public void clickEventHandler(MouseEvent event) {
		return;
	}

}
