package ca.utoronto.utm.paint;

import ca.utoronto.utm.paint.ManipulatorStrategies.*;
import javafx.scene.paint.Color;

public class StrategyFactory {
	
	private View view;
	
	/**
	 * Creates a new StrategyFactory which takes input from the user and returns a strategy to perform
	 * needed actions to fulfill the user's input
	 * @param view
	 */
	public StrategyFactory(View view) {
		this.view = view;
	}
	
	/**
	 * Takes a string from the panels and returns the according strategy
	 * @param strategy The string associated with user input
	 * @return the corresponding ManipulatorStrategy to the input
	 */
	public ManipulatorStrategy createStrategy(String strategy) {
		if (strategy == "Circle") {
			return new CircleManipulatorStrategy(this.view);
		}
		else if (strategy == "Polyline") {
			return new PolylineManipulatorStrategy(this.view);

		}
		else if (strategy == "Rectangle") {
			return new RectangleManipulatorStrategy(this.view);
		}
		else if (strategy == "Square") {
			return new SquareManipulatorStrategy(this.view);
		}
		else if (strategy == "Squiggle") {
			return new SquiggleManipulatorStrategy(this.view);
		}
		
		else if (strategy == "Triangle") {
			return new TriangleManipulatorStrategy(this.view);
		}
		
		else if (strategy == "Eraser") {
			return new EraserManipulatorStrategy(this.view);
		}
		
		else if (strategy == "Fill") {
			return new OutlineManipulatorStrategy(this.view);
		}
		
		else if (strategy == "Outline") {
			return new FillManipulatorStrategy(this.view);
		}
		return null;
		
	}
	
	/**
	 * Takes a colour as a parameter and returns the correct ColourManipulatorStrategy
	 * @param colour the colour selected by the user
	 * @return the corresponding ColourManipulatorStrategy
	 */
	public ManipulatorStrategy createStrategy(Color colour) {
		return new ColourManipulatorStrategy(this.view, colour);
	}
	
	/**
	 * Takes a double and returns the correct ThicknessManipulatorStrategy
	 * @param thickness the user's desired thickness
	 * @return the corresponding ThicknessManipulatorStrategy
	 */
	public ManipulatorStrategy createStrategy(double thickness) {
		return new ThicknessManipulatorStrategy(this.view, thickness);
	}
}
