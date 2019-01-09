package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Rectangle;
import javafx.scene.input.MouseEvent;

public class RectangleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	/**
	 * Creates a new RectangleManipulatorStrategy to handle mouse events
	 * @param view
	 */
	public RectangleManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	public void mouseDragHandler(MouseEvent e) {
		((Rectangle) this.drawingCommand).setEndCorner(new Point((int) e.getX(), (int) e.getY()));
		model.setChangedandNotify();
	}

	@Override
	public void mouseClickHandler(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressHandler(MouseEvent e) {
		Point startCorner = new Point((int) e.getX(), (int) e.getY());
		Point endCorner = new Point((int) e.getX(), (int) e.getY());
		this.setDrawingCommand(new Rectangle());
		((Rectangle) this.drawingCommand).setStartCorner(startCorner);
		((Rectangle) this.drawingCommand).setEndCorner(endCorner);
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
