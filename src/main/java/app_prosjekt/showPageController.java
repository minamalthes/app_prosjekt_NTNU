package app_prosjekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class showPageController {
     private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML private ListView<Show> shows;
    @FXML private Button back;
    
    private ScreenplayList screenPlayList = new ScreenplayList();

    public void switchToFirstPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize(){
        shows.getItems().addAll(screenPlayList.getAllShows());
    }

}
