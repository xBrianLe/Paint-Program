package ca.utoronto.utm.paint.Panels;

import java.util.ArrayList;

import ca.utoronto.utm.paint.StrategyFactory;
import ca.utoronto.utm.paint.View;
import ca.utoronto.utm.paint.ManipulatorStrategies.ManipulatorStrategy;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class ThicknessPanel extends GridPane implements EventHandler<MouseEvent>  {

	private ArrayList<PaintButton> buttons;
	final Slider thickSlider = new Slider(1, 9, 1);
	private Label thickLabel;
	private View view;
	double amount = 0;
	double x;
	private StrategyFactory factory;
	
	/**
	 * Creates a new panel for thickness which includes a slider for the user to select desired shape thickness
	 * @param view
	 */
	public ThicknessPanel(View view) {
		this.setHgap(7.0);
		this.view = view;
		this.thickLabel = new Label("Thickness: ");
		this.add(thickLabel, 1, 8);
		thickSlider.setBlockIncrement(1);
		thickSlider.setMaxWidth(115.0);
		thickSlider.setMajorTickUnit(1);
		thickSlider.setMinorTickCount(0);
		thickSlider.setShowTickLabels(true);
		thickSlider.setSnapToTicks(true);
		thickSlider.setOnMouseReleased(this);
		this.add(thickSlider, 1, 9);
		
		this.factory = new StrategyFactory(this.view);
	}
	
	public double getThickness() {
		return this.thickSlider.getValue();
	}
	
	/**
	 * Sends the chosen thickness to the StrategyFactory and sets the PaintPanels strategy to the strategy returned 
	 * by the factory
	 * @param event The MouseEvent on the slider
	 */
	public void handle(MouseEvent event) {
		
		x = ((Slider) event.getSource()).getValue();
		ManipulatorStrategy strategy = this.factory.createStrategy(x);
		this.view.getPaintPanel().setOptionStrategy(strategy);
		
		
	}
}
