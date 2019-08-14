package readfromfiles;

import addwordsfromfile.CreatingHashMapFromWords;
import addwordsfromfile.MyReader;
import addwordsfromfile.SendWordsFromArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.util.HashMap;


public class Controller {

    @FXML
    Button CloseButton, AddTheWordsButton;
    @FXML
    TextField PathToFileTextField;
    @FXML
    Label InfoLabel;


    CreatingHashMapFromWords createHashMap = new CreatingHashMapFromWords();
    SendWordsFromArrayList sendWords = new SendWordsFromArrayList();
    @FXML
    public void handleCloseButton(ActionEvent e){
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void addFromFile(ActionEvent e){
        MyReader reader = new MyReader();
        String path = PathToFileTextField.getText().trim();
        SendWordsFromArrayList send = new SendWordsFromArrayList();
        String[] stringArray = null;
        HashMap<String,String> hashMap = null;
        try {
            stringArray = reader.Reader(path);
            hashMap = createHashMap.createHashMap(stringArray);
            send.send(hashMap);
            InfoLabel.setText("Sikeres beolvasás!");
        }catch (IOException q){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel a fájlból olvasásnál!");
            alert.setHeaderText("Az elérési út, vagy a fájlnév hibás!");
            alert.setContentText("Kérlek ellenőrizd a megadott adatokat!");
            alert.showAndWait();
        }

    }
}
