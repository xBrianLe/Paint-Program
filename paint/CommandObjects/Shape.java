package ca.utoronto.utm.paint.CommandObjects;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public abstract class Shape extends DrawingCommand{
	
		/**
		 * Creates new DrawingCommand with this.type = "shape".
		 */
		public Shape() {
			this.type = "shape";
		}	
        public abstract void execute(GraphicsContext g);
}
