package ca.utoronto.utm.paint.Panels;

import ca.utoronto.utm.paint.StrategyFactory;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.ManipulatorStrategies.ManipulatorStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PalettePanel extends GridPane implements EventHandler<ActionEvent>{

	private View view;
	private StrategyFactory factory;
	final Color[] colours = new Color[] {Color.WHITE, Color.LIGHTGRAY, Color.RED, Color.DARKRED, 
			Color.DARKORANGE, Color.ORANGE, Color.LIGHTGOLDENRODYELLOW, Color.YELLOW, 
			Color.YELLOWGREEN, Color.GREEN, Color.STEELBLUE, Color.BLUE, Color.INDIGO, 
			Color.VIOLET,Color.MEDIUMORCHID, Color.DARKORCHID, Color.PURPLE, Color.DEEPPINK, Color.DARKGREY, 
			Color.BLACK};
	
	ColourButton[] buttons = new ColourButton[20];
	Color selectedColour;
	
	/**
	 * Creates a new Panel for the user to select colours
	 * @param view
	 */
	public PalettePanel(View view){
		this.view = view;
		this.setHgap(7.0);
		int i = 0;
		int x = 1;
		int y = 1;
		while (i < 20) {
			this.buttons[i] = new ColourButton(colours[i]);
			this.buttons[i].setOnAction(this);
			this.buttons[i].setMinSize(50, 25);
			this.add(this.buttons[i], x, y);
			if (x == 1) {x = 2;}
			else {
				x = 1;
				y++;
			}	
			i++;
		}
		this.selectedColour = Color.BLACK;
		this.factory = new StrategyFactory(this.view);
		
	}
	public Color getColour() {
		return this.selectedColour;
	}

	@Override
	/**
	 * Sends the selected colour to the factory and outputs a strategy which is set to the view
	 * @param e the ActionEvent that occured
	 */
	public void handle(ActionEvent e) {
		
		this.selectedColour = ((ColourButton) e.getSource()).getColour();
		this.view.getMasterPanel().getCurrentColourPanel().setColour(this.selectedColour);
		ManipulatorStrategy strategy = this.factory.createStrategy(this.selectedColour);
		this.view.getPaintPanel().setOptionStrategy(strategy);
	}
	
}