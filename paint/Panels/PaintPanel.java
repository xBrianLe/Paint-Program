package ca.utoronto.utm.paint.Panels;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.CommandObjects.DrawingCommand;
import ca.utoronto.utm.paint.CommandObjects.Shape;
import ca.utoronto.utm.paint.ManipulatorStrategies.ManipulatorStrategy;
import ca.utoronto.utm.paint.ManipulatorStrategies.ShapeManipulatorStrategy;

public class PaintPanel extends StackPane implements Observer, EventHandler<MouseEvent> {

	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private Shape mode; // modifies how we interpret input and builds the shape
	private Canvas canvas;
	private ManipulatorStrategy optionStrategy;
	private ShapeManipulatorStrategy shapeStrategy;
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(1280, 720);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");
		this.addEventHandler(MouseEvent.ANY, this);

		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}
	
	public void newCanvas() {
		this.model.clearCommandObjects(this.canvas.getGraphicsContext2D());
		this.repaint();
	}

	/**
	 * Clears the canvas and executes all commands in the command stack
	 */
	public void repaint() {
		GraphicsContext g = this.canvas.getGraphicsContext2D();

		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());		

		
		ArrayList<DrawingCommand> commands = this.model.getDrawingCommand();
		for (DrawingCommand dc: commands ) {
			dc.execute(g);
		}
	}
	

	@Override
	/**
	 * Calls repaint whenever an update has been called
	 */
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		this.repaint();
		
	}
	
	public Shape getCommand() {
		return this.mode;
	}

	public void setShapeStrategy(ShapeManipulatorStrategy strategy) {
		this.shapeStrategy = strategy;
	}
	
	public void setOptionStrategy(ManipulatorStrategy strategy) {
		this.optionStrategy = strategy;
	}

	@Override
	/**
	 * Calls the handler of mouse events from the ShapeManipulatorStrategy class
	 */
	public void handle(MouseEvent event) {
		try {
			this.shapeStrategy.clickEventHandler(event);
		} catch(NullPointerException e) {
			return;
		}
		
		
	}	    

}