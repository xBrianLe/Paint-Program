package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Square;
import javafx.scene.input.MouseEvent;

public class SquareManipulatorStrategy extends RectangleManipulatorStrategy {
	/**
	 * Creates a SquareManipulatorStrategy to handle mouse events for squares
	 * @param view
	 */
	public SquareManipulatorStrategy(View view) {
		
		super(view);
	}
	
	public void mousePressHandler(MouseEvent e) {
		Point startCorner = new Point((int) e.getX(), (int) e.getY());
		Point endCorner = new Point((int) e.getX(), (int) e.getY());
		this.setDrawingCommand(new Square());
		((Square) this.drawingCommand).setStartCorner(startCorner);
		((Square) this.drawingCommand).setEndCorner(endCorner);
		this.addCommandToModel();

	}

	
}
