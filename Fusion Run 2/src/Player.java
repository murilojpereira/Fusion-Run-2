import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle {

	String type;
	boolean dead = false;
	
	Player(int x, int y, int w, int h, String type, Color color) {
		
		super(w, h, color);
		
		this.type = type;
		
		setTranslateX(x);
		setTranslateY(y);
		
	}
	
	void moveLeft(int speed) {
		setTranslateX(getTranslateX()-speed);
	}
	
	void moveRight(int speed) {
		setTranslateX(getTranslateX()+speed);	
	}
	
	void moveUp(int speed) {
		setTranslateY(getTranslateY()-speed);
	}
	
	void moveDown(int speed) {
		setTranslateY(getTranslateY()+speed);
	}
	
}
