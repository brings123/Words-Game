package TpSrc;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginCont implements Initializable{

    @FXML
    private JFXComboBox<String> combo;
    
    private Joueur p = new Joueur();
    
    @FXML
    void Return(ActionEvent event) throws Exception {
    	Main.ReturnMain();
    }
    
    @FXML
    void Play(ActionEvent event)  {
    	if(combo.getValue()!=null)
    	{
    		for(Joueur p1 :Main.Game.players)
    		{
    			if(p1.getPseudo().equals(combo.getValue())) 
    			{
    				p=p1;
    			}
    		}
        	Main.Game.connect(p);
        	try {
    			Main.Game.createGame();
    			Main.showStage();
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Main.Game.players =NewGameCont.readfile();
		ArrayList<String> combolist = new ArrayList<String>();
		for(Joueur p :Main.Game.players)
		{
			combolist.add(p.getPseudo());
		}
		combo.setItems(FXCollections.observableArrayList(combolist));
	}

}
