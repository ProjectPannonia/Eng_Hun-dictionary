package sample;

import javafx.scene.control.Alert;
import myalerts.MyAlerts;

import java.util.ArrayList;

public class PairChecker {
    CreateArraylistFromDatabase createArrayList = new CreateArraylistFromDatabase();
    ArrayList<Word> myDatabase = createArrayList.getAllWord();
    MyAlerts alerts = new MyAlerts();

    public boolean checkIfExistingPair(ArrayList<Word> list, String eng, String hun){
        boolean flag = false;
        for(Word w : list){
            if(w.getEng().equals(eng) && w.getHun().equals(hun)) {
                alerts.alreadyExistPair();
                flag = true;
                break;
            }
        }
        return flag;
    }
}
