package main.checkers;

import main.myalerts.MyAlerts;
import main.Word;

import java.util.ArrayList;

public class PairChecker {
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
