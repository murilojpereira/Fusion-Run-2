import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FusionRun2 extends Application{
	
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 600;
	
	int playerSpeed = 5;
	
	int obsSpeed = 5;
	
	//StartScreen
	
	
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("Fusion Run 2");
		Group window = new Group();
		Scene scene = new Scene(window, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		FancyButton button = new FancyButton(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 100, 60, "button", Color.BLUE, "Click", Color.WHITE);
		window.getChildren().add(button);
		window.getChildren().add(button.ButtonText);

		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args){
		
		launch(args);
		
	}

}
