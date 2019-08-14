package main;

import main.send.SendSimpleWordPair;
import main.checkers.PairChecker;
import main.creators.CreateArraylistFromDatabase;
import main.myalerts.MyAlerts;
import main.checkers.EmptyCheck;
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
        MyAlerts myAlerts = new MyAlerts();
        EmptyCheck ec = new EmptyCheck();
        PairChecker pairCheck = new PairChecker();
        CreateArraylistFromDatabase createList = new CreateArraylistFromDatabase();
        ArrayList<Word> list = createList.getAllWord();
        String eng = EngWordAddTbox.getText().toLowerCase();
        String hun = HunWordAddTbox.getText().toLowerCase();
            if(ec.twoEmpty(eng,hun)){
                myAlerts.addWordNull();
            }else if(ec.engAddEmpty(eng,hun)) {
                myAlerts.engAddEmpty();
            }else if(ec.hunEmpty(eng,hun)){
                myAlerts.hunAddEmpty();
            }else if(!pairCheck.checkIfExistingPair(list,eng,hun)) {
                awe.addUserP(eng, hun);
                System.out.println("Sikeres adatküldés!");
            }
    }

    // Search button method
    @FXML
    public void SearchWord(ActionEvent e) {
        EmptyCheck ec = new EmptyCheck();
        WordCounter wc = new WordCounter();
        CreateArraylistFromDatabase calfd = new CreateArraylistFromDatabase();
        // Store English searchbox content
        String eng = EngSearchTbox.getText();

        // Store Hungarian searchbox content
        String hun = HunSearchTbox.getText();

        // Get all wordpair from the database
        ArrayList<Word> words = calfd.getAllWord();

        // Translate hungarian to english
        if (ec.hunEmpty(eng,hun)) {
            String english = EngSearchTbox.getText().toLowerCase().trim();
            boolean hit = false;
                for (Word w : words) {
                    if (w.getEng().toLowerCase().equals(english)) {
                        HunSearchTbox.setText(w.getHun().toLowerCase());
                        hit = true;
                    }
                }
                // If word not on the database
                if(hit != true) {
                    MyAlerts myAlerts = new MyAlerts();
                    myAlerts.hit();
                }

        // Translate english to hungarian
        } else if (ec.engEmpty(eng,hun)) {
            String hungarian = HunSearchTbox.getText().toLowerCase().trim();
            boolean hit = false;
            for (Word w : words) {
                if (w.getHun().toLowerCase().equals(hungarian)) {
                    EngSearchTbox.setText(w.getEng().toLowerCase());

                    hit = true;
                }
            }
            // If word not on the database
            if(hit != true) {
                MyAlerts myAlerts = new MyAlerts();
                myAlerts.hit();

            }

            // All (search) fields not empty
        } else if (ec.notEmpty(eng,hun)) {
            MyAlerts myAlerts = new MyAlerts();
            myAlerts.alertNotEmpty();
            // All (search) field empty
        } else if (ec.twoEmpty(eng,hun)) {
            MyAlerts myAlerts = new MyAlerts();
            myAlerts.alertTwoEmpty();
        }
        System.out.println(wc.WordCounter());
    }
}
