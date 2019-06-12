import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Obstacle extends Circle{
	
	Obstacle(int x, int y, int r, Color c, int speed){
		
		super(r);
		setFill(c);
		setCenterX(x);
		setCenterY(y);
			
	}
	
}
