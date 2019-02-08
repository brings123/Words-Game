package TpSrc;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainCont {

    @FXML
    void Close(ActionEvent event) {
    	Main.primaryStage.close();
    }

    @FXML
    void Play(ActionEvent event) throws Exception {
    	Main.showLogin();
    }

    @FXML
    void createNewPlayer(ActionEvent event) throws Exception {
    	Main.showNewPlayer();
    }

}
