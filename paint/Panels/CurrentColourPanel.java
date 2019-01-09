package ca.utoronto.utm.paint.Panels;

import ca.utoronto.utm.paint.View;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class CurrentColourPanel extends GridPane {
	
	ColourButton colourbutton = new ColourButton(Color.BLACK);
	
	public CurrentColourPanel(View v) {
		this.setHgap(10.0);
		this.add(colourbutton, 1, 0);
		colourbutton.setMinWidth(100.0);
	}
	
	public void setColour(Color c) {
		this.colourbutton.setColour(c);
	}
	
}