package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Squiggle;
import javafx.scene.input.MouseEvent;

public class SquiggleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	/**
	 * Creates a new SquiggleManipulatorStrategy to handle mouse events for squiggles
	 * @param view
	 */
	public SquiggleManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	public void mouseDragHandler(MouseEvent e) {
		Point p = new Point((int) e.getX(), (int) e.getY());
		((Squiggle) this.drawingCommand).addPoint(p);
		model.setChangedandNotify();
	}

	@Override
	public void mouseClickHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressHandler(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		this.setDrawingCommand(new Squiggle());
		this.addCommandToModel();
	}

	@Override
	public void mouseReleaseHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEnterHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExitHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoveHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
