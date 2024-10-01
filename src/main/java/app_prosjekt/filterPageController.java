package app_prosjekt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
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

public class filterPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private ScreenplayList screenPlayList = new ScreenplayList();
    private Screenplay screenplay;
    @FXML private ListView<Screenplay> filterBox; 


    @FXML 
    private Button type;

    @FXML 
    private Button rating;

    @FXML 
    private Button year;

    @FXML 
    private Button back;

    

    @FXML
    public void initialize(){
        filterBox.getItems().addAll(screenPlayList.getAllScreenplays());

    }
    
     public void switchToFirstPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sortType(){
        // ScreenplayComparator typeComparator = new ScreenplayComparator("Type");
        // screenPlayList.sortType(typeComparator);
        // filterBox.getItems().clear();
        // ArrayList<Screenplay> screenplaylist = new ArrayList<Screenplay>();
        // for (Screenplay screenplay : screenPlayList) {
        //     screenplaylist.add(screenplay);
        // }
        // filterBox.getItems().addAll(screenplaylist);

        ScreenplayComparator yearComparator = new ScreenplayComparator("Type");
        ArrayList<Screenplay> sortedScreenplays = screenPlayList.sortYear(yearComparator);
        filterBox.getItems().clear();
        for (Screenplay screenplay : sortedScreenplays) {
            filterBox.getItems().add(screenplay);
        }
    }

    public void sortYear(){

        ScreenplayComparator yearComparator = new ScreenplayComparator("Year");
        ArrayList<Screenplay> sortedScreenplays = screenPlayList.sortYear(yearComparator);
    
        filterBox.getItems().clear(); // Fjern alle eksisterende elementer fra filterBox

        // Legg til de sorterte skuespillene i filterBox
        for (Screenplay screenplay : sortedScreenplays) {
            filterBox.getItems().add(screenplay);
        }
    }
 
    public void sortRating(){
        ScreenplayComparator ratingComparator = new ScreenplayComparator("Rating");
        ArrayList<Screenplay> sortedScreenplays = screenPlayList.sortRating(ratingComparator); //averagerating
       
        
        filterBox.getItems().clear(); // Fjern alle eksisterende elementer fra filterBox
        
        // Legg til de sorterte skuespillene i filterBox
        filterBox.getItems().addAll(sortedScreenplays);
    }
}
