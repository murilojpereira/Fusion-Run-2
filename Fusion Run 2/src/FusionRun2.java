import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FusionRun2 extends Application{
	
	Scene start, game;
	
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 600;
	
	int playerSpeed = 5;
	
	int obsSpeed = 5;
	
	//StartScreen
	
	
	public void start(Stage stage) throws Exception{
		
		stage.setTitle("Fusion Run 2");
		
		//Start scene
		Group layout = new Group();
		start = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);
		FancyButton button = new FancyButton(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2, 100, 60, "button", Color.BLUE, "Click", Color.WHITE);
		button.setOnMouseClicked(e -> stage.setScene(game)); button.ButtonText.setOnMouseClicked(e -> stage.setScene(game));
		layout.getChildren().addAll(button, button.ButtonText);
		
		//Game scene
		Group gameLayout = new Group();
		game = new Scene(gameLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
		game.setFill(Color.DIMGRAY);
		
		Player player = new Player(30, 30, 10, 10, "player", Color.ALICEBLUE);
		gameLayout.getChildren().addAll(player);
		
		//Shows stage
		stage.setScene(start);
		stage.show();
		
	}
	
	class GameTimer extends Animation {
		
		public void handle(long now) {
			
			
			
		}
		
	}
	
	public static void main(String[] args){
		
		launch(args);
		
	}

}
