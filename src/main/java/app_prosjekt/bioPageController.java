package app_prosjekt;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class bioPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML private TextField bioText;
    @FXML private TextArea bioBox;

    @FXML private Button saveButton;
    @FXML private Button readButton;
    

    public void switchToFirstPage(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    

    public void saveBio(){
        String bio = bioText.getText();
        CSVBio minProfil = new CSVBio("MinProfil");
        try {
            minProfil.saveBio(bio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBio(){
        CSVBio minProfil = new CSVBio("MinProfil");
        try {
            String bio = minProfil.readBio();
            bioBox.setText(bio);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

}
