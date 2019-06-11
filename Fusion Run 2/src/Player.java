import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {

	String type;
	boolean dead = false;
	
	Player(int x, int y, int w, int h, String type, Color color) {
		
		super(w, h, color);
		
		this.type = type;
		
		setX(x);
		setY(y);
		
	}
	
	void moveLeft(int speed) {
		setX(getX()-speed);
	}
	
	void moveRight(int speed) {
		setX(getX()+speed);	
	}
	
	void moveUp(int speed) {
		setY(getY()-speed);
	}
	
	void moveDown(int speed) {
		setY(getY()+speed);
	}
	
}
