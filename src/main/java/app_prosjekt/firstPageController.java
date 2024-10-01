package app_prosjekt;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class firstPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private ScreenplayList screenPlayList = new ScreenplayList();

    @FXML private ListView<Movie> movies;
    @FXML private ListView<Movie> shows;
    @FXML private ListView<Movie> filterStart;

    @FXML private Button showPageButton;
    @FXML private Button moviePageButton;
    @FXML private Button filterPageButton;

    

    public void switchToMoviePage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("moviePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       
    }

    public void switchToShowPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("showPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToFilterPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("filterPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBioPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("bioPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

}
