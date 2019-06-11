import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FusionRun2 extends Application{
	
	Scene start, game, customize;
	
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 600;
	
	GameTimer timer;
	
	Player demo;
	
	Player player;
	int playerSpeed = 5;
	
	int obsSpeed = 5;
	
	//StartScreen
	
	
	public void start(Stage stage) throws Exception{
		
		stage.setTitle("Fusion Run 2");
		
		//Start scene
		Group layout = new Group();
		start = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);
		FancyButton gameButton = new FancyButton(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2, 100, 60, "gameButton", Color.BLUE, "Click", Color.WHITE);
		gameButton.setOnMouseClicked(e -> stage.setScene(game)); gameButton.ButtonText.setOnMouseClicked(e -> stage.setScene(game));
		FancyButton customizeButton = new FancyButton(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2 + 100, 100, 60, "cutomizeButton", Color.RED, "Customize", Color.WHITE);
		customizeButton.setOnMouseClicked(e -> stage.setScene(customize)); gameButton.ButtonText.setOnMouseClicked(e -> stage.setScene(customize));
		layout.getChildren().addAll(gameButton, gameButton.ButtonText, customizeButton, customizeButton.ButtonText);
		
		//Character Select scene
		Group customizeLayout = new Group();
		customize = new Scene(customizeLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
		demo = new Player(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2-50, 100, 100, "demo", Color.ALICEBLUE);
		FancyButton blue = new FancyButton(SCREEN_WIDTH/2-40, SCREEN_HEIGHT/2 + 100, 80, 40, "blue", Color.BLUE, "Blue", Color.ALICEBLUE);
		blue.setOnMouseClicked(e -> demo.setFill(Color.BLUE)); blue.ButtonText.setOnMouseClicked(e -> demo.setFill(Color.BLUE));
		customizeLayout.getChildren().addAll(demo, blue, blue.ButtonText);
		
		//Game scene
		Group gameLayout = new Group();
		game = new Scene(gameLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
		game.setFill(Color.DIMGRAY);
		player = new Player(40, 40, 10, 10, "player", Color.ALICEBLUE);
		gameLayout.getChildren().addAll(player);
		//Game Movement
		game.setOnKeyPressed(e -> handleKeyPressed(e));
		
		//Starts Timer
		timer = new GameTimer();
		timer.start();
		
		
		//Shows stage
		stage.setScene(start);
		stage.show();
		
	}
	
	class GameTimer extends AnimationTimer {
		@Override
		public void handle(long now) {
			
			Bounds playerBounds = player.getBoundsInLocal();
			
			if (playerBounds.getMinY() <= 0) {
				playerSpeed = 0;
				player.setY(1);
			} else {
				playerSpeed = 5;
			}
			
		}
		
	}
	
    private void handleKeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
        
        //int move_x=0;
        int move_right = code == KeyCode.D? 1:0;
        int move_left = code == KeyCode.A? 1:0;
        int move_up = code == KeyCode.W? 1:0;
        int move_down = code == KeyCode.S? 1:0;
        
        //if (code == KeyCode.D) move_x=1;
        player.move(move_right-move_left,move_down-move_up);
        
//        if (code == KeyCode.W) {
//            player.moveUp(playerSpeed);
//        } if (code == KeyCode.S) {
//            player.moveDown(playerSpeed);
//        } if (code == KeyCode.A) {
//        	player.moveLeft(playerSpeed);
//        } if (code == KeyCode.D) {
//        	player.moveRight(playerSpeed);
//        }
         if (code == KeyCode.SPACE) {
            // pause the game
            timer.stop();;
        }// else if (code == KeyCode.ENTER) {
            // restart the game
          //  timer.start();
        //}

    }
	
	public static void main(String[] args){
		
		launch(args);
		
	}

}
