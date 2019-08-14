package main.readfromfiles;

import main.creators.CreatingHashMapFromWords;
import main.reader.MyReader;
import main.send.SendWordsFromArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.myalerts.MyAlerts;

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
            MyAlerts alerts = new MyAlerts();
            alerts.readError();
        }
    }
}
