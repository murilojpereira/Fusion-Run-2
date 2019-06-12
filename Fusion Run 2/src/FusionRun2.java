import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FusionRun2 extends Application{
	
	Scene start, game, customize;
	
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 600;
	
	GameTimer timer;
	
	Player demo;
	
	Player player;
	int direction;
	int playerSpeed = 5;
	int x_velocity = 0;
	int Y_velocity = 0;
	
	int obsSpeed = 5;
	
	//StartScreen
	
	
	public void start(Stage stage) throws Exception{
		
		stage.setTitle("Fusion Run 2");
		
		
		
		///////////////
		//START SCENE//
		///////////////
		Group layout = new Group();
		start = new Scene(layout, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		FancyButton gameButton = new FancyButton(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2, 100, 60, "gameButton", Color.BLUE, "Click", Color.WHITE);
		gameButton.setOnMouseClicked(e -> stage.setScene(game)); gameButton.ButtonText.setOnMouseClicked(e -> stage.setScene(game));
		
		FancyButton customizeButton = new FancyButton(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2 + 100, 100, 60, "cutomizeButton", Color.RED, "Customize", Color.WHITE);
		customizeButton.setOnMouseClicked(e -> stage.setScene(customize)); gameButton.ButtonText.setOnMouseClicked(e -> stage.setScene(customize));
		
		layout.getChildren().addAll(gameButton, gameButton.ButtonText, customizeButton, customizeButton.ButtonText);
		
		
		
		///////////////////////
		//CUSTOMIZATION SCENE//
		///////////////////////
		Group customizeLayout = new Group();
		customize = new Scene(customizeLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
		customize.setFill(Color.DIMGRAY);
		
		Rectangle demo = new Rectangle(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2-50, 100, 100);
		demo.setFill(Color.ALICEBLUE);//(SCREEN_WIDTH/2-50, SCREEN_HEIGHT/2-50, 100, 100, "demo", Color.ALICEBLUE)
		
		//Player color picker
		ColorPicker colorPicker = new ColorPicker(Color.ALICEBLUE);
		colorPicker.setLayoutX(SCREEN_WIDTH/2-63);
		colorPicker.setLayoutY(demo.getX()+50);
		colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                player.setFill(colorPicker.getValue());
                demo.setFill(colorPicker.getValue());
            }
        });
		
		//Back button
		Button backButton = new Button("Back");
		backButton.setLayoutX(20);
		backButton.setLayoutY(20);
		backButton.setOnAction(e -> stage.setScene(start));
		
		//adds to layout
		customizeLayout.getChildren().addAll(demo, colorPicker, backButton);
		
		
		
		//////////////
		//GAME SCENE//
		//////////////
		Group gameLayout = new Group();
		game = new Scene(gameLayout, SCREEN_WIDTH, SCREEN_HEIGHT);
		game.setFill(Color.DIMGRAY);
		player = new Player(40, 40, 10, 10, "player", Color.ALICEBLUE);
		gameLayout.getChildren().addAll(player);
		
		//Game Movement
		game.setOnKeyPressed(e -> handleKeyPressed(e));
		game.setOnKeyReleased(e -> handleKeyReleased(e));
		
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
				player.y_velocity = 0;
				player.setY(1);
			} if (playerBounds.getMaxY() >= SCREEN_HEIGHT) {
				player.y_velocity = 0;
				player.setY(SCREEN_HEIGHT - 11);
			} if (playerBounds.getMinX() <= 0) {
				player.x_velocity = 0;
				player.setX(1);
			} if (playerBounds.getMaxX() >= SCREEN_WIDTH) {
				player.x_velocity = 0;
				player.setX(SCREEN_WIDTH-11);
			}
			else {
				playerSpeed = 5;
			}
			
			player.setX(player.getX()+player.x_velocity);
			player.setY(player.getY()+player.y_velocity);
			
		}
		
	}
	
    private void handleKeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
        
        //Movement
        if (code == KeyCode.W) {
            player.y_direction = -1;
            player.y_velocity = player.speed * player.y_direction;
        } if (code == KeyCode.S) {
            player.y_direction = 1;
            player.y_velocity = player.speed * player.y_direction;
        } if (code == KeyCode.A) {
        	player.x_direction = -1;
        	player.x_velocity = player.speed * player.x_direction;
        } if (code == KeyCode.D) {
        	player.x_direction = 1;
        	player.x_velocity = player.speed * player.x_direction;
        }
         
        //Pausing
        if (code == KeyCode.SPACE) {
            // pause the game
            timer.stop();
        }if (code == KeyCode.ENTER) {
            //restart the game
            timer.start();
        }

    }
    
    private void handleKeyReleased(KeyEvent event) {
    	KeyCode code = event.getCode();
    	
    	if (code == KeyCode.W || code == KeyCode.S) {
    		player.y_velocity = 0;
    	} if (code == KeyCode.A || code == KeyCode.D) {
    		player.x_velocity = 0;
    	} 
    	
    }
	
	public static void main(String[] args){
		
		launch(args);
		
	}

}
