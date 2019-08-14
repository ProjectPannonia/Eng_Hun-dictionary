package sample;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class PairChecker {
    CreateArraylistFromDatabase createArrayList = new CreateArraylistFromDatabase();
    ArrayList<Word> myDatabase = createArrayList.getAllWord();
    public void checkIfExistingPair(ArrayList<Word> list, String eng, String hun){
        for(Word w : list){
            if(w.getEng().equals(eng) && w.getHun().equals(hun)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hiba!");
                alert.setHeaderText("A megadott szó pár már megtalálható a szótárban!");
                alert.setContentText("Kérlek adj meg másik szó párt!");
                alert.showAndWait();
            }
        }
    }
}
