package readFromFiles;

import AddWordsFromFile.CreatingHashMapFromWords;
import AddWordsFromFile.MyReader;
import AddWordsFromFile.SendWordsFromArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;


public class Controller {

    @FXML
    Button BackButton, AddTheWordsButton;
    @FXML
    TextField PathToFileTextField;
    @FXML
    Label InfoLabel;

    MyReader reader = new MyReader();
    CreatingHashMapFromWords createHashMap = new CreatingHashMapFromWords();
    SendWordsFromArrayList sendWords = new SendWordsFromArrayList();
    //Back button functionality

    @FXML
    public void addFromFile(ActionEvent e){
        String path = PathToFileTextField.getText().trim();
        String[] stringArray = null;
        HashMap<String,String> hashMap = null;
        try {
            stringArray = reader.Reader(path);
            hashMap = createHashMap.createHashMap(stringArray);

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
