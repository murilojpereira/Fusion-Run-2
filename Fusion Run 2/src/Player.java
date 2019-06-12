import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {

	String type;
	boolean dead = false;
	int speed;
	int x_direction;
	int y_direction;
	int x_velocity;
	int y_velocity;
	//int acceleration = 1;
	Player(int x, int y, int w, int h, String type, Color color) {
		
		super(w, h, color);
		
		this.type = type;
		this.speed = 7;
		this.x_direction = 0;
		this.x_velocity = speed * x_direction;
		this.y_direction = 0;
		this.y_velocity = speed * y_direction;
		
		setX(x);
		setY(y);
		
	}
	
	void setCenterX(int x) {
		
		setX(x-getWidth()/2);
		
	}
	
	void setCenterY(int y) {
		
		setY(y-getHeight()/2);
		
	}
	
}
