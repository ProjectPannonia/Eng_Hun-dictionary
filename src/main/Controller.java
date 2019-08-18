package main;

import main.checker.*;
import main.checker.EngAddEmpty;
import main.myalerts.*;
import main.send.SendSimpleWordPair;
import main.creator.CreateArraylistFromDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.translate.ToEnglish;
import main.translate.ToHungarian;
import main.translate.Translate;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //Search box one, Search box two,Add new hungarian word here,Add new english word here
    @FXML
    TextField EngSearchTbox,HunSearchTbox,EngWordAddTbox,HunWordAddTbox;

    //Returned hun word,Returned eng word
    @FXML
    Label TitleLabel;

    //Search button for searching english word,Search button for searching hungarian word
    @FXML
    Button SearchButton,BrowseButton;

    //The word is successfully added to the database
    @FXML
    Label AddedLabel;

    @FXML
    public void wordsFromFile(ActionEvent e){
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("fxmls/fromFile.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Read new words from file");
            stage.setScene(new Scene(root,626,650));
            stage.show();
            ((Node)(e.getSource())).getScene().getWindow();
        }catch (IOException x){
            x.printStackTrace();;
        }
    }

    @FXML
    public void addWordEng(ActionEvent e) {
        SendSimpleWordPair awe = new SendSimpleWordPair();
        EmptyCheck ec = new EmptyCheck();
        PairChecker pairCheck = new PairChecker();
        CreateArraylistFromDatabase createList = new CreateArraylistFromDatabase();
        ArrayList<Word> list = createList.getAllWord();
        String eng = EngWordAddTbox.getText().toLowerCase();
        String hun = HunWordAddTbox.getText().toLowerCase();

            if(new TwoEmptyField().check(eng,hun)){
                new AlertAddWordNull().SendAlert();
            }else if(new EngAddEmpty().check(eng,hun)) {
                new AlertEngAddEmpty().SendAlert();
            }else if(new SearchHunWord().check(eng,hun)){
                new AlertHunAddEmpty().SendAlert();
            }else if(!pairCheck.checkIfExistingPair(list,eng,hun)) {
                awe.addUserP(eng, hun);
                System.out.println("Sikeres adatküldés!");
            }
    }

    // Search button method
    @FXML
    public void SearchWord(ActionEvent e) {
        EmptyCheck emptyCheck = new EmptyCheck();
        WordCounter wordCounter = new WordCounter();
        CreateArraylistFromDatabase database = new CreateArraylistFromDatabase();
        // Store English searchbox content
        String eng = EngSearchTbox.getText();

        // Store Hungarian searchbox content
        String hun = HunSearchTbox.getText();

        // Get all wordpair from the database
        ArrayList<Word> words = database.getAllWord();

        // Translate hungarian to english
        if (new SearchHunWord().check(eng,hun)) {
            //String hungarian = HunSearchTbox.getText().toLowerCase().trim();
            Translate toHungarian = new ToHungarian();
            String hu = toHungarian.translate(eng);
            boolean hit = false;
            if (hu != null){
                hit = true;
                HunSearchTbox.setText(hu);
            }
                // If word not in the database
                if(hit == false) {
                    new AlertHit().SendAlert();
                }

        // Translate english to hungarian
        } else if (new SearchEngWord().check(eng,hun)) {
            Translate toEnglish = new ToEnglish();
            String english = toEnglish.translate(hun);
            boolean hit = false;
            if(english != null){
                hit = true;
                EngSearchTbox.setText(english);
            }
            if (hit == false){
                new AlertHit().SendAlert();
            }
            // All (search) fields not empty
        } else if (new NotEmpty().check(eng,hun)) {
            new Alertnotempty().SendAlert();
        } else if (new TwoEmptyField().check(eng,hun)) {
            new AlertTwoEmpty().SendAlert();
        }
        System.out.println(wordCounter.WordCounter());
    }
}
