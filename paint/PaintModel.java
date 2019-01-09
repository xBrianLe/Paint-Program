package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import ca.utoronto.utm.paint.CommandObjects.ColourCommand;
import ca.utoronto.utm.paint.CommandObjects.DrawingCommand;
import ca.utoronto.utm.paint.CommandObjects.OutlineCommand;
import ca.utoronto.utm.paint.CommandObjects.ThicknessCommand;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintModel extends Observable {
	
	private ArrayList<DrawingCommand> commandArray = new ArrayList<DrawingCommand>();
	
	/**
	 * Creates a new PaintModel with the default commands added to the command stack
	 */
	public PaintModel() {
		
		commandArray.add(new OutlineCommand());
		
		ColourCommand CC = new ColourCommand();
		CC.setColour(Color.BLACK);
		commandArray.add(CC);
		
		ThicknessCommand TC = new ThicknessCommand();
		TC.setThickness(1);
		commandArray.add(TC);
	}
	
	/**
	 * Execute setChanged and notifyObservers methods
	 */
	public void setChangedandNotify() {
		this.setChanged();
		this.notifyObservers();
		
	}
	/**
	 * Adds a DrawingCommand c to the command stack 
	 * @param c the command being added
	 */
	public void addCommand(DrawingCommand c) {
		this.commandArray.add(c);
		this.setChangedandNotify();

	}
	
	
	/**
	 * Removes from model the shape last added to model.
	 */
	public void removeLatestShape() {
		for(int counter = this.commandArray.size() - 1; counter >= 0; counter--){
			if (commandArray.get(counter).getType() == "shape") {
				commandArray.remove(counter);
				this.setChangedandNotify();
				break;
			}
		}
	}	
		
	public ArrayList<DrawingCommand> getDrawingCommand() {
		return this.commandArray;
	}

	/**
	 * Removes all command objects from model and adds required objects reflecting current state of 
	 * application (colour, thickness, fill & outline).
	 * @param g GraphicsContext from canvas
	 */
	public void clearCommandObjects(GraphicsContext g) {
		this.commandArray = new ArrayList<DrawingCommand>();
		commandArray.add(new OutlineCommand());
		
		ColourCommand CC = new ColourCommand();
		CC.setColour((Color) g.getStroke());
		commandArray.add(CC);
		
		ThicknessCommand TC = new ThicknessCommand();
		TC.setThickness(g.getLineWidth());
		commandArray.add(TC);
		
	}
}

