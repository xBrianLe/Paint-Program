package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.View;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public abstract class ShapeManipulatorStrategy extends ManipulatorStrategy{
	
	/**
	 * Creates a ShapeManipulatorStrategy
	 * @param view
	 */
	public ShapeManipulatorStrategy(View view) {
		super(view);
		this.type = "Shape";
	}
	/**
	 * Performs shape-specific actions when the mouse is dragged
	 * @param e The MouseEvent that occurred
	 */
	public abstract void mouseDragHandler(MouseEvent e);
	
	/**
	 * Performs shape-specific actions when the mouse is clicked
	 * @param e The MouseEvent that occurred
	 */
	public abstract void mouseClickHandler(MouseEvent e);
	
	/**
	 * Performs shape-specific actions when the mouse is pressed
	 * @param e The MouseEvent that occurred
	 */
	public abstract void mousePressHandler(MouseEvent e);
	
	/**
	 * Performs shape-specific actions when the mouse is released
	 * @param e The MouseEvent that occurred
	 */
	public abstract void mouseReleaseHandler(MouseEvent e);
	
	/**
	 * Performs shape-specific actions when the mouse
	 * @param e The MouseEvent that occurred
	 */
	public abstract void mouseEnterHandler(MouseEvent e);
	
	public abstract void mouseExitHandler(MouseEvent e);
	public abstract void mouseMoveHandler(MouseEvent e);
	
	/**
	 * Analyzes the event and calls the correct mouse handler
	 * @event the MouseEvent that occurred
	 */
	public void clickEventHandler(MouseEvent event) {
		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			this.mouseDragHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.mousePressHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			this.mouseMoveHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			this.mouseClickHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			this.mouseReleaseHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			this.mouseEnterHandler(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			this.mouseExitHandler(event);
		}

	}
}
