package ca.utoronto.utm.paint.Panels;

import ca.utoronto.utm.paint.StrategyFactory;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.ManipulatorStrategies.ManipulatorStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Creates a panel on view with a button to provide an option to users to switch between
 * filling or outlining shapes.
 * @param view
 */
public class FillPanel extends GridPane implements EventHandler<ActionEvent> {
	private Button fillButton;
	final ColorPicker colourPicker = new ColorPicker(Color.WHITE);
	private View view;
	private StrategyFactory factory;
	
	/**
	 * Creates a new Panel with a button so the user may change the fill value.
	 * @param view
	 */
	public FillPanel (View view) {
		this.view = view;
		this.setHgap(10.0);
		this.fillButton = new Button("Outline");
		this.fillButton.setMinWidth(100);
		this.fillButton.setOnAction(this);
		this.add(fillButton, 1, 0);
		this.factory = new StrategyFactory(this.view);
	}
	
	/**
	 * Creates a new strategy and sets the drawing mode to fill/outline depending on the text 
	 * on the button when it is pressed
	 * @param event the ActionEvent of the button when pressed
	 */
	public void handle(ActionEvent event) {
		
		ManipulatorStrategy strategy = this.factory.createStrategy(((Button) event.getSource()).getText());
		this.view.getPaintPanel().setOptionStrategy(strategy);

		if (((Button) event.getSource()).getText() == "Fill") {
            this.fillButton.setText("Outline");
        }
        else if (((Button) event.getSource()).getText() == "Outline") {
            this.fillButton.setText("Fill");
        }
		
	}
}
