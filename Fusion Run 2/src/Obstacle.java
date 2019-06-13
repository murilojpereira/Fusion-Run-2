import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Obstacle extends Circle{
	
	int speed = 7;
	
	Obstacle(int x, int y, int r, Color c, int speed){
		
		super(r);
		setFill(c);
		setCenterX(x);
		setCenterY(y);
			
	}
	
//	void createObstacles(int ammount, int origin) {
//		
//		Obstacle[] obstacles = new Obstacle[ammount];  
//		
//		for (int i = 0; i > ammount; i++) {
//			
//			obstacles[i] = new Obstacle(randomNumber(0, SCREEN_WIDTH), 5, 5, Color.RED, 7);
//			
//		}
//		
//	}
	
    double randomNumber(int low, int high) {
        int range = high - low + 1;
        return Math.random() * range + low;
    }
	
}
