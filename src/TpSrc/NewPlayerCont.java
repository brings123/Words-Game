package TpSrc;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class NewPlayerCont implements Initializable {

    @FXML
    private JFXTextField username;
    
    @FXML
    private Label error;
    
    @FXML
    void Return(ActionEvent event) throws Exception {
    	Main.ReturnMain();
    }

    @FXML
    void createNewPlayer(ActionEvent event) {
    	
    	try {
    		Main.Game.players =NewGameCont.readfile();
			Main.Game.createAccount(username.getText());
			//NewGameCont.writefile(Main.Game.players);
			
			try {
				Main.Game.createGame();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Main.showStage();
		} catch (AcountExist e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			error.setText("This player Already exists");
		} catch (FalsePseudoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			error.setText("Unacceptable Name, use another one");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}