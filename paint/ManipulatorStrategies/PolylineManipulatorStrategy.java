package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Polyline;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class PolylineManipulatorStrategy extends ShapeManipulatorStrategy {
	
	/**
	 * Creates a new PolylineManipulatorStrategy to handle mouse events
	 * @param view
	 */
	public PolylineManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	public void mouseDragHandler(MouseEvent e) {
	}

	@Override
	public void mouseClickHandler(MouseEvent e) {
		if ((e.getButton() == MouseButton.SECONDARY)) {
			Polyline p = new Polyline();
			p.setStartFlag(true);
			this.setDrawingCommand(p);
			
		} else {
		
		if (this.drawingCommand == null) {
			this.setDrawingCommand(new Polyline());
		}

		if (((Polyline) this.drawingCommand).getStartFlag()) {
			this.setDrawingCommand(new Polyline());
			((Polyline) this.drawingCommand).addPoint(new Point((int) e.getX(), (int) e.getY()));
			((Polyline) this.drawingCommand).setStartFlag(false);
			this.addCommandToModel();
			model.setChangedandNotify();
			} else {
			((Polyline) this.drawingCommand).addPoint(new Point((int) e.getX(), (int) e.getY()));
			model.setChangedandNotify();
		}
		
		}
	}

	@Override
	public void mousePressHandler(MouseEvent e) {
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
		Point p = new Point((int) e.getX(), (int) e.getY());
		((Polyline) this.drawingCommand).addPoint(p);
		model.setChangedandNotify();
		((Polyline) this.drawingCommand).removeLatestPoint();

	}

}
