package sample;

import checkers.EmptyCheck;
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
    EmptyCheck ec = new EmptyCheck();
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
    Label AddedLabel,SearchedWordLabel;

    @FXML
    Pane AncorPane;
    @FXML
    VBox menuVBox;
/*
    @FXML
    public void Browse(ActionEvent e){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a text file!");
        fileChooser.showOpenDialog();
    }
*/
    @FXML
    public void addWordEng(ActionEvent e) {
        String eng = EngWordAddTbox.getText().toLowerCase();
        String hun = HunWordAddTbox.getText().toLowerCase();

        if (ec.twoEmpty(eng,hun)) {
            awe.addUserP(eng, hun);
            AddedLabel.setText(eng + " - " + hun + "\n" + "Added!");
            System.out.println("Sikeres adatküldés!");
        } else {
            System.out.println("A mezők értéke nem lehet null!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel!");
            alert.setHeaderText("Mindkét beviteli mező üres!");
            alert.setContentText("Kérlek a bal oldali mezőben add meg az angol, a jobb oldaliba pedig a magyar szót!");
            alert.showAndWait();
            System.out.println("Hibás bevitel, a mezők nem tartalmaznak értéket!");
        }
    }
    // Search button method
    @FXML
    public void SearchWord(ActionEvent e) {
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
            if(hit == false) SearchedWordLabel.setText("Nincs találat!");
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
            if(hit == false) SearchedWordLabel.setText("Nincs találat!");

            // All (search) fields not empty
        } else if (ec.notEmpty(eng,hun)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel!");
            alert.setHeaderText("Mindkét mező adatot tartalmaz!");
            alert.setContentText("Kérlek csak a keresett szót írd be. A másik mezőből töröld az szöveget!");
            alert.showAndWait();
            System.out.println("Hibás bevitel! Mindkét mező adatot tartalmaz!");
            // All (search) field empty
        } else if (ec.twoEmpty(eng,hun)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hibás bevitel!");
            alert.setHeaderText("Mindkét mező üres!");
            alert.setContentText("Valamelyik mezőbe írd be a nyelvnek megfelelő keresett szót!");
            alert.showAndWait();
            System.out.println("Hibás bevitel! Mindkét mező üres!");
        }
        System.out.println(wc.WordCounter());
    }
}
