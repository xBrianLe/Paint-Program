package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.OutlineCommand;
import javafx.scene.input.MouseEvent;

public class OutlineManipulatorStrategy extends ManipulatorStrategy {
	
	/**
	 * Creates a new OutlineManipulatorStrategy and adds the OutlineCommand to the model command stack
	 * @param view
	 */
	public OutlineManipulatorStrategy(View view) {
		super(view);
		this.setDrawingCommand(new OutlineCommand());
		this.addCommandToModel();
	}
	
	public void clickEventHandler(MouseEvent event) {
		return;
	}


}
