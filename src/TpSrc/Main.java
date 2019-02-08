package TpSrc;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage primaryStage ;
	public static Stage stage = new Stage();
	public static Stage stage1 = new Stage();
	public static BorderPane mainlayOut;
	public static Stage secondaryStage=new Stage();
	public static GameManager Game = new GameManager();
	public static ArrayList<Integer> Choice = new ArrayList<Integer>();
	public static int fail=0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage=primaryStage;
		Main.primaryStage.setResizable(false);
		showMainView();
		//showScore();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void showMainView() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("Mainmenu.fxml"));
		mainlayOut=loader.load();
		Scene scene = new Scene(mainlayOut);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showscoreviewer() throws IOException {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("scoreviewer.fxml"));
		AnchorPane mainlayOut=loader.load();
		Scene scene = new Scene(mainlayOut);
		secondaryStage.setScene(scene);
		secondaryStage.showAndWait();
	}
	
	public static void ReturnMain() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("Mainmenu.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}
	
	public static void showLogin() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("Login.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}
	
	public static void showNewPlayer() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("NewPlayer.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}
	
	public static void showStage() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("NewGame.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}
	
	public static void showScore() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("score.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}
	
	public static void showLetterChoice() throws IOException{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(Main.class.getResource("NewStage.fxml"));
		BorderPane mainMenuPane=loader.load();
		mainlayOut.setCenter(mainMenuPane);
		
	}

}
