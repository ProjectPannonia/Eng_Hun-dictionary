package main.Controllers;

import main.Word;
import main.checker.PairChecker;
import main.creator.ArraylistToHashmap;
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
        CreateArraylistFromDatabase createFromDatabase = new CreateArraylistFromDatabase();
        MyReader reader = new MyReader();
        SendWordsFromArrayList send = new SendWordsFromArrayList();
        PairChecker paircheck = new PairChecker();
        ArraylistToHashmap listToHashmap = new ArraylistToHashmap();

        String pathToTheFile;
        ArrayList<Word> alreadyInDatabase;
        HashMap<String,String> duplicatedRemoved;
        String[] newWords;
        HashMap<String,String> newHashmap;
        HashMap<String,String> databaseHashmap;

        try {
            // Read the path of the file
            pathToTheFile = PathToFileTextField.getText().trim();

            // Store the words that are already stored int the database
            alreadyInDatabase = createFromDatabase.getAllWord();
            databaseHashmap = listToHashmap.create(alreadyInDatabase);

            // Read the words from the file and store in a string array
            newWords = reader.Reader(pathToTheFile);

            // Creating a new hashmap from the string[] array
            newHashmap = createHashMap.createHashMap(newWords);

            duplicatedRemoved = paircheck.checkPairFileRead(databaseHashmap,newHashmap);
            send.send(duplicatedRemoved);
            InfoLabel.setText("Sikeres beolvasás!");
        }catch (IOException q){
            new ReadError().SendAlert();
        }
    }
}
