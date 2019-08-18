package main.send;

import main.checker.PairChecker;

import java.util.HashMap;
import java.util.Map;

public class SendWordsFromArrayList {
    SendSimpleWordPair add = new SendSimpleWordPair();

    public void send(HashMap<String,String> map){
        for(Map.Entry<String,String> entry : map.entrySet()){
            if(entry.getKey() != null && !entry.getKey().equals("") && entry.getValue() != null && !entry.getValue().equals("")) {
                add.addUserP(entry.getKey(), entry.getValue());
            }
        }
    }
}
