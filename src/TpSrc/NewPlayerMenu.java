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

public class NewPlayerMenu extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		JFXButton NewPlayer = new JFXButton();
		JFXButton Return = new JFXButton();
		JFXTextField username = new JFXTextField();
		Stage primaryStage = new Stage();
		//BorderPane root = new BorderPane();
		AnchorPane root = new AnchorPane();
		
		NewPlayer.setText("NewPlayer");
		NewPlayer.setStyle("fx-background-color:blue");
		NewPlayer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(!username.getText().equals(""))
				{
					
					//MainMenu.Game.createAccount(username.getText());
		    		try {
						MainMenu.Game.createGame();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		root.getChildren().addAll(NewPlayer,username);
		Scene mainScene = new Scene(root,800,600);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

}
