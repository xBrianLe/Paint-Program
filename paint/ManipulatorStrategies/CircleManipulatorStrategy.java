package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Circle;
import javafx.scene.input.MouseEvent;

public class CircleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	/**
	 * Creates a CircleManipulatorStrategy to handle mouse events for circles
	 * @param view 
	 */
	public CircleManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	public void mouseDragHandler(MouseEvent e) {
		int dx = (int) ((Circle) this.drawingCommand).getCentre().getX() - (int) e.getX();
		int dy = (int) ((Circle) this.drawingCommand).getCentre().getY() - (int) e.getY();
		int r = (int) Math.sqrt(dx*dx + dy*dy);
		((Circle)drawingCommand).setRadius(r);
		
		this.model.setChangedandNotify();
	}

	@Override
	public void mouseClickHandler(MouseEvent e) {}

	@Override
	public void mousePressHandler(MouseEvent e) {
		Point centre = new Point((int) e.getX(), (int) e.getY());
		this.setDrawingCommand(new Circle());
		((Circle) this.drawingCommand).setCentre(centre);
		this.addCommandToModel();
		model.setChangedandNotify();
	}

	@Override
	public void mouseReleaseHandler(MouseEvent e) {}

	@Override
	public void mouseEnterHandler(MouseEvent e) {}

	@Override
	public void mouseExitHandler(MouseEvent e) {}

	@Override
	public void mouseMoveHandler(MouseEvent e) {}
	

}
