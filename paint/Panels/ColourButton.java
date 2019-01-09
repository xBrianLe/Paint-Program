package ca.utoronto.utm.paint.Panels;

import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ColourButton extends ToggleButton{
	
	private Color colour;
	private Insets inset;
	
	/**
	 * Creates a button that a user can select to change colour
	 * @param colour
	 */
	public ColourButton(Color colour) {
		this.colour = colour;
		inset = new Insets(5);
		this.setBackground(new Background(new BackgroundFill(this.colour, CornerRadii.EMPTY, inset)));
	}
	public Color getColour() {
		return this.colour;
	}
	public void setColour(Color c) {
		BackgroundFill fill = new BackgroundFill(c, CornerRadii.EMPTY, inset);
		Background bg = new Background(fill);
		this.setBackground(bg);
	}
}