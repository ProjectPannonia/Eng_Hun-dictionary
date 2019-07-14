package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {
    addWordEng awe = new addWordEng();
    DB db = new DB();
    SearchEngWord sew = new SearchEngWord();
    CreateArraylistFromDatabase calfd = new CreateArraylistFromDatabase();
    WordCounter wc = new WordCounter();
    //Search box one
    @FXML
    TextField EngSearchTbox;
    //Search box two
    @FXML
    TextField HunSearchTbox;
    //Returned hun word
    @FXML
    Label HunWordLabel;
    //Returned eng word
    @FXML
    Label EngWordLabel;
    //Search button for searching english word
    @FXML
    Button EngSearchButton;
    //Search button for searching hungarian word
    @FXML
    Button HunSearchButton;
    //Add new english word here
    @FXML
    TextField EngWordAddTbox;
    //Add new hungarian word here
    @FXML
    TextField HunWordAddTbox;
    //The word is successfully added to the database
    @FXML
    Label AddedLabel;
    @FXML
    Label SearchedWordLabel;
    @FXML
    Button SearchButton;
    @FXML
    Label TitleLabel;
    @FXML
    Pane AncorPane;
    @FXML
    VBox menuVBox;

    @FXML
    public void addWordEng(ActionEvent e) {
        String eng = EngWordAddTbox.getText();
        String hun = HunWordAddTbox.getText();
        if (eng != null && hun != null) {
            awe.addUserP(eng, hun);
            AddedLabel.setText(eng + " - " + hun + "\n" + "Added!");
            System.out.println("Sikeres adatküldés!");
        } else {
            System.out.println("A mezők értéke nem lehet null!");
        }
    }

    @FXML
    public void SearchWord(ActionEvent e) {
        boolean en = EngSearchTbox.getText().trim().isEmpty();
        boolean hu = HunSearchTbox.getText().trim().isEmpty();
        ArrayList<Word> words = calfd.getAllWord();
        if (!en && hu) {
            String eng = EngSearchTbox.getText();
            boolean hit = false;
            for (Word w : words) {
                if (w.getEng().equals(eng)) {
                    //SearchedWordLabel.setText(w.getEng() + " - " + w.getHun());
                    HunSearchTbox.setText(w.getHun());
                    hit = true;
                }
            }
            if(hit == false) SearchedWordLabel.setText("Nincs találat!");
        } else if (en && !hu) {
            String hun = HunSearchTbox.getText();
            boolean hit = false;
            for (Word w : words) {
                if (w.getHun().equals(hun)) {
                    //SearchedWordLabel.setText(w.getHun() + " - " + w.getEng());
                    EngSearchTbox.setText(w.getEng());

                    hit = true;
                }
            }
            if(hit == false) SearchedWordLabel.setText("Nincs találat!");
        } else if (!en && !hu) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel!");
            alert.setHeaderText("Mindkét mező adatot tartalmaz!");
            alert.setContentText("Kérlek csak a keresett szót írd be. A másik mezőből töröld az szöveget!");
            alert.showAndWait();
            System.out.println("Hibás bevitel! Mindkét mező adatot tartalmaz!");
        } else if (en && hu) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel!");
            alert.setHeaderText("Mindkét mező üres!");
            alert.setContentText("Valamelyik mezőbe írd be a nyelvnek megfelelő keresett szót!");
            alert.showAndWait();
            System.out.println("Hibás bevitel! Mindkét mező üres!");
        }
        System.out.println(wc.WordCounter());
/*
    @FXML
    public void EngWordSearch(ActionEvent e){
        String eng = EngSearchTbox.getText();
        ArrayList<Word> words = calfd.getAllWord();
        for(Word w : words){
            if(w.getEng().equals(eng)){
                SearchedWordLabel.setText(w.getHun());
                words = null;
            }else{
                System.out.println("Nincs ilyen szó az adatbázisban!");
            }
        }
    }
*/
    /*@FXML
    public void HunWordSearch(ActionEvent e){
        String hun = HunSearchTbox.getText();
        ArrayList<Word> words = calfd.getAllWord();
        for(Word w : words){
            if(w.getHun().equals(hun)){
                SearchedWordLabel.setText(w.getEng());
                words = null;
            }else{
                System.out.println("Nincs ilyen szó az adatbázisban!");
            }
        }
    }
    */
    }
}
