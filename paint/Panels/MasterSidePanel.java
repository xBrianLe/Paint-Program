package ca.utoronto.utm.paint.Panels;

import ca.utoronto.utm.paint.View;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MasterSidePanel extends GridPane {
	private View view;
	private CurrentColourPanel current;
	private PalettePanel palette;
	private FillPanel fillPanel;
	private Pane spacer;
	private ShapeChooserPanel shapePanel;
	private ThicknessPanel thicknessPanel;
	
	/**
	 * Creates a side panel to hold all other side panels inside it
	 * @param view
	 */
	public MasterSidePanel(View view) {
		this.view = view;
		this.current = new CurrentColourPanel(this.view);
		this.shapePanel = new ShapeChooserPanel(this.view);
		this.fillPanel = new FillPanel(this.view);
		this.spacer = new Pane();
		this.spacer.setPrefHeight(10.0);
		this.palette = new PalettePanel(this.view);
		this.palette.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.thicknessPanel = new ThicknessPanel(this.view);
		
		this.add(shapePanel, 1, 1);
		this.add(thicknessPanel,1,2);
		this.add(fillPanel, 1, 3);
		this.add(spacer, 1, 4);
		this.add(palette, 1, 5);
		this.add(current, 1, 6);
		
	}
	public CurrentColourPanel getCurrentColourPanel() {
		return this.current;
	}
}
