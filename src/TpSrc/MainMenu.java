package TpSrc;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainMenu extends Application {
	
	public static void main (String[]args){
		launch(args);
	}
	
	public static GameManager Game = new GameManager();
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		JFXButton NewPlayer = new JFXButton();
		JFXButton ExistantPlayer = new JFXButton();
		JFXButton Exit = new JFXButton();
		JFXTextField username = new JFXTextField();
		Stage primaryStage = new Stage();
		//BorderPane root = new BorderPane();
		AnchorPane root = new AnchorPane();
		
		NewPlayer.setText("NewPlayer");
		NewPlayer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				NewPlayerMenu a = new NewPlayerMenu();
				try {
					primaryStage.close();
					a.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//NewPlayerMenu.launch(NewPlayerMenu.class);
			}
		});
		Exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				primaryStage.close();
			}		
		});
		ExistantPlayer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		root.getChildren().addAll(NewPlayer,ExistantPlayer,Exit);
		Scene mainScene = new Scene(root,800,600);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	

}
