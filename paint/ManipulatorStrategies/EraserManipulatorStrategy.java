package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Eraser;
import javafx.scene.input.MouseEvent;

public class EraserManipulatorStrategy extends SquiggleManipulatorStrategy {
	
	/**
	 * Creates a new EraserManipulatorStrategy
	 * @param view
	 */
	public EraserManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	/**
	 * Adds a new Eraser object to the DrawingCommand and adds it to the model
	 * @param e the MouseEvent that occured
	 */
	public void mousePressHandler(MouseEvent e) {
		this.setDrawingCommand(new Eraser());
		this.addCommandToModel();
	}

}
