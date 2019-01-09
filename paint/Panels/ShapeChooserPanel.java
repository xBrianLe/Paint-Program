package ca.utoronto.utm.paint.Panels;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.ArrayList;

import ca.utoronto.utm.paint.StrategyFactory;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.ManipulatorStrategies.ShapeManipulatorStrategy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseDragEvent;


public class ShapeChooserPanel extends GridPane implements EventHandler<ActionEvent> {
	
	final ColorPicker colourPicker = new ColorPicker(Color.WHITE);
	private View view; // So we can talk to our parent or other components of the view
	private ArrayList<PaintButton> buttons;
	private ToggleGroup buttonGroup;
	private StrategyFactory factory;
	final Slider thickSlider = new Slider(0, 10, 1);
	private Label thickLabel;
	private PalettePanel palette;
	private FillPanel fillpanel;
	private ThicknessPanel thicknesspanel;
	
	/**
	 * Creates a panel that allows the user to select a drawing method
	 * @param view
	 */
	public ShapeChooserPanel(View view) {
		
		this.view = view;
		this.setVgap(2);
		buttonGroup = new ToggleGroup();
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Triangle", "Squiggle", "Polyline", "Eraser" };
		this.buttons = new ArrayList<PaintButton>();
		int row = 1;
		this.setHgap(10.0);
		
		for (String label : buttonLabels) {
			PaintButton button = new PaintButton(label);
			
			Image image = new Image(getClass().getResourceAsStream("media/"+label+".png"));
			button.setMinWidth(100);
			button.setGraphic(new ImageView(image));
			button.setToggleGroup(buttonGroup);
			buttons.add(button);
			this.add(button, 1, row);
			row++;
			button.setOnAction(this);
			this.factory = new StrategyFactory(this.view);
		}

			
		
		for(int i = 0; i < 13; i++) {
			Label tmp = new Label("");
			this.add(tmp, 2, i);
		}
			
			this.factory = new StrategyFactory(this.view);


		for(int i = 0; i < 13; i++) {
			Label tmp = new Label("");
			this.add(tmp, 2, i);
		}
		
}
	
	String command;
	public String getCommand()
	{
		return this.command;
	}
	
	/**
	 * Sends the button press to the factory and sets the paintpanel's strategy to the strategy
	 * from the factory
	 */
	public void handle(ActionEvent event) {
		String command = ((PaintButton) event.getSource()).getMode();
		ShapeManipulatorStrategy strategy = (ShapeManipulatorStrategy) this.factory.createStrategy(command);

		this.view.getPaintPanel().setShapeStrategy(strategy);
		
		for (PaintButton button : this.buttons) {
			if (button != event.getSource()) {

			}
			
		return;
		}
	}

}
