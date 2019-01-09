package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.Point;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.Triangle;
import javafx.scene.input.MouseEvent;

public class TriangleManipulatorStrategy extends ShapeManipulatorStrategy {
	
	/**
	 * Creates a new TriangleManipulatorStrategy to handle mouse events for Triangles
	 * @param view
	 */
	public TriangleManipulatorStrategy(View view) {
		super(view);
	}
	
	@Override
	public void mouseDragHandler(MouseEvent e) {
	}

	@Override
	public void mouseClickHandler(MouseEvent e) {
		if(this.drawingCommand == null) {
			this.setDrawingCommand(new Triangle());
		}
		
		if(((Triangle) this.drawingCommand).getSize() == 0){
//			this.setDrawingCommand(new Triangle());
			((Triangle) this.drawingCommand).addPoint(new Point((int) e.getX(), (int) e.getY()));
			
			this.addCommandToModel();;
			this.model.setChangedandNotify();
		}
		
		else if(((Triangle) this.drawingCommand).getSize() < 3){
			((Triangle) this.drawingCommand).addPoint(new Point((int) e.getX(), (int) e.getY()));
			model.setChangedandNotify();
		}
		
		else {
			this.setDrawingCommand(null);
			this.mouseClickHandler(e);
		}

		}
		

	

	@Override
	public void mousePressHandler(MouseEvent e) {
	}

	@Override
	public void mouseReleaseHandler(MouseEvent e) {
	}

	@Override
	public void mouseEnterHandler(MouseEvent e) {
	}


	@Override
	public void mouseMoveHandler(MouseEvent e) {
		if(this.drawingCommand == null) {
			return;
		}
		
		if(((Triangle) this.drawingCommand).getSize() != 0){
			((Triangle) this.drawingCommand).addPoint(new Point((int) e.getX(), (int) e.getY()));
			model.setChangedandNotify();
			((Triangle) this.drawingCommand).removepreviouspoints();
			
		}		

	}

	@Override
	public void mouseExitHandler(MouseEvent e) {		
	}

}
