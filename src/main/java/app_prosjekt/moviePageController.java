package app_prosjekt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class moviePageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private ListView<Movie> movies;
    @FXML private Button back;
    @FXML private TextField addRatingBox;

    private ScreenplayList screenPlayList = new ScreenplayList();

    public void switchToFirstPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        movies.getItems().addAll(screenPlayList.getAllMovies());
    }


    
}
