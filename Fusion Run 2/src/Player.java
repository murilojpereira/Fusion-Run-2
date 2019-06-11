import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {

	String type;
	boolean dead = false;
	int speed=5;
	int x_velocity = 0;
	int y_velocity = 0;
	//int acceleration = 1;
	Player(int x, int y, int w, int h, String type, Color color) {
		
		super(w, h, color);
		
		this.type = type;
		
		setX(x);
		setY(y);
		
	}
	
	void move(int x_direction, int y_direction){
		
		x_velocity=speed*x_direction;
		y_velocity=speed*y_direction;
		setX(getX()+x_velocity);
		setY(getY()+y_velocity);
	}
	
//	
//	void moveLeft(int speed) {
//		setX(getX()-speed);
//	}
//	
//	void moveRight(int speed) {
//		setX(getX()+speed);	
//	}
//	
//	void moveUp(int speed) {
//		setY(getY()-speed);
//	}
//	
//	void moveDown(int speed) {
//		setY(getY()+speed);
//	}
	
}
