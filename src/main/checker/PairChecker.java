package main.checker;

import main.creator.ArraylistToHashmap;
import main.myalerts.AlreadyExistPair;
import main.Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PairChecker {
    public boolean checkIfExistingPair(ArrayList<Word> list, String eng, String hun){
        boolean flag = false;
        for(Word w : list){
            if(w.getEng().equals(eng) && w.getHun().equals(hun)) {
                new AlreadyExistPair().SendAlert();
                flag = true;
                break;
            }
        }
        return flag;
    }
    public HashMap<String,String> checkPairFileRead(HashMap<String,String> database, HashMap<String,String> newFile){

        String hunInNewFIle;
        String engInNewFile;
        HashMap<String,String> removedDuplicated = new HashMap<>();

        outer: for (Map.Entry<String,String> map : newFile.entrySet()){
            boolean flag = false;
            String eng = map.getKey();
            String hun = map.getValue();
            for(Map.Entry<String,String> datab : database.entrySet()){

                if(eng.equals(datab.getKey()) && hun.equals(datab.getValue())){
                    System.out.println("Eggyezést találtam!");
                    flag = true;
                    //continue outer;
                }
            }
            if (!flag) {
                System.out.println("Elküldve !");
                removedDuplicated.put(map.getKey(),map.getValue());
            }
        }
        return removedDuplicated;
    }
}
