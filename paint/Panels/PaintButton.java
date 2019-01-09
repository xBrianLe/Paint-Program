package ca.utoronto.utm.paint.Panels;

public class PaintButton extends javafx.scene.control.ToggleButton {
	String mode;
	
	public PaintButton(String mode) {
		super();
		this.setMode(mode);
	}

	public void setMode(String s) {
		this.mode = s;
	}
	
	public String getMode() {
		return this.mode;
	}
}
