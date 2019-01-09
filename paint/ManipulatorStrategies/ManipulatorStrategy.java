package ca.utoronto.utm.paint.ManipulatorStrategies;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.DrawingCommand;
import javafx.scene.input.MouseEvent;

public abstract class ManipulatorStrategy {
	protected String type;
	protected View view;
	protected PaintModel model;
	protected DrawingCommand drawingCommand;
	
	/**
	 * Creates a new ManipulatorStrategy 
	 * @param view
	 */
	public ManipulatorStrategy(View view) {
		this.view = view;
		this.model = view.getModel();
		this.type = "Option";
	}
	
	public String getType() {
		return this.type;
	}
	
	protected void setDrawingCommand(DrawingCommand d) {
		this.drawingCommand = d;
	}
	
	/**
	 * Adds the DrawingCommand to the model's command stack
	 */
	protected void addCommandToModel() {
		this.model.addCommand(this.drawingCommand);
	}

	public abstract void clickEventHandler(MouseEvent event);
	
}
