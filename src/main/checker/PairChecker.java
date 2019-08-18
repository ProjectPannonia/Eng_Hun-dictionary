package main.checker;

import main.myalerts.MyAlerts;
import main.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public HashMap<String,String> checkPairFileRead(ArrayList<Word> database, HashMap<String,String> newFile){

        String hunInNewFIle = null;
        String engInNewFile = null;
        HashMap<String,String> removedDuplicated = new HashMap<>();

        for (Map.Entry<String,String> map : newFile.entrySet()){
            hunInNewFIle = map.getValue().trim();
            engInNewFile = map.getKey().trim();

            for (Word db : database){
                boolean flag = false;
                if((engInNewFile.trim().equals(db.getEng()) && hunInNewFIle.trim().equals(db.getHun()))){
                    flag = true;
                }
                if(flag == false) removedDuplicated.put(engInNewFile,hunInNewFIle);
            }
        }

        return removedDuplicated;
    }
}
