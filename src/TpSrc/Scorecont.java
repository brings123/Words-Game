package TpSrc;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Scorecont implements Initializable{

    @FXML
    private ImageView Hungedman;

    @FXML
    private JFXButton Nextt;

    @FXML
    private Label playername;

    @FXML
    private Label meilleurscore;

    @FXML
    private Label score;

    @FXML
    private JFXButton close;
    
    @FXML
    private JFXButton sc;

    @FXML
    void Newgame(ActionEvent event) throws Exception {
    	Main.Game.stage1=new Stage("mots.poo");
    	Main.Choice=new ArrayList<>();
    	Main.fail=0;
    	Main.showStage();
    }

    @FXML
    void close(ActionEvent event) {
    	Main.Game.players.add(GameManager.meanPlayer);
    	NewGameCont.writefile(Main.Game.players);
    	Main.primaryStage.close();
    }

    @FXML
    void savescore(ActionEvent event) {
    	GameManager.meanPlayer.saveScore(Main.Game.stage1.getCurrentScore());
    	sc.setDisable(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for(Mot word:Stage.words)
		{
			word.calculateScore();
		}
		Main.Game.stage1.calculateTotalScore();
		playername.setText("Player :  "+ GameManager.meanPlayer.getPseudo());
		meilleurscore.setText("Best score:  "+GameManager.meanPlayer.getMeilleurScaore());
		score.setText("Score:  "+Main.Game.stage1.getCurrentScore());
	}

}
