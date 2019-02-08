package TpSrc;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class scoreviewercont implements Initializable {

    @FXML
    private JFXListView<Integer> list;

    @FXML
    private JFXButton score1;

    @FXML
    void showscore(ActionEvent event) {
    	Main.secondaryStage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		list.setItems(FXCollections.observableArrayList(GameManager.meanPlayer.getScorelist()));
		
	}

}
