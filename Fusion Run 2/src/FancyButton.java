import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FancyButton extends Rectangle {
	
	Text ButtonText;
	
	String type;
	
	FancyButton(int x, int y, int w, int h, String type, Color color, String text, Color textColor){
		
		super(w, h, color);
		
		this.type = type;
		
		setTranslateX(x);
		setTranslateY(y);
		
		ButtonText = new Text(text);
		ButtonText.setFill(textColor);
		ButtonText.setFont(Font.font("century gothic", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ButtonText.setX(x+w/4);
		ButtonText.setY(y+h/2);
		
		this.setOnMouseClicked(e -> {
			this.setFill(color.desaturate());
		});
		
		ButtonText.setOnMouseClicked(e -> {
			this.setFill(color.desaturate());
		});
		
	}
	
}
