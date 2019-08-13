package AddWordsFromFile;

import sample.addWordEng;

import java.util.HashMap;
import java.util.Map;

public class SendWordsFromArrayList {
    sample.addWordEng add = new addWordEng();

    public void send(HashMap<String,String> map){
        for(Map.Entry<String,String> entry : map.entrySet()){
            add.addUserP(entry.getKey(),entry.getValue());
        }
    }
}
