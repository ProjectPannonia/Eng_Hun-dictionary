package main.Controllers;

import main.Word;
import main.checker.PairChecker;
import main.creator.CreateArraylistFromDatabase;
import main.creator.CreatingHashMapFromWords;
import main.myalerts.ReadError;
import main.reader.MyReader;
import main.send.SendWordsFromArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FileReadController {

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
        CreateArraylistFromDatabase createFromDatabese = new CreateArraylistFromDatabase();
        ArrayList<Word> databaseWords = createFromDatabese.getAllWord();
        MyReader reader = new MyReader();
        String path = PathToFileTextField.getText().trim();
        SendWordsFromArrayList send = new SendWordsFromArrayList();
        HashMap<String,String> duplicatedRemoved;
        PairChecker paircheck = new PairChecker();
        String[] stringArray = null;
        HashMap<String,String> hashMap = null;
        try {
            stringArray = reader.Reader(path);
            hashMap = createHashMap.createHashMap(stringArray);
            duplicatedRemoved = paircheck.checkPairFileRead(databaseWords,hashMap);
            send.send(duplicatedRemoved);
            InfoLabel.setText("Sikeres beolvasás!");
        }catch (IOException q){
            new ReadError().SendAlert();
        }
    }
}
