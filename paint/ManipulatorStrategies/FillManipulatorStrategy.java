package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.FillCommand;
import javafx.scene.input.MouseEvent;

public class FillManipulatorStrategy extends ManipulatorStrategy {
	
	/**
	 * Creates a new FillManipulatirStrategy and sets the DrawingCommand to a FillCommand then sends it to model
	 * @param view
	 */
	public FillManipulatorStrategy(View view) {
		super(view);
		this.setDrawingCommand(new FillCommand());
		this.addCommandToModel();
	}
	
	public void clickEventHandler(MouseEvent event) {
		return;
	}


}
