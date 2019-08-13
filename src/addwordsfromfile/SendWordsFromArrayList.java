package addwordsfromfile;

import sample.AddWordEng;

import java.util.HashMap;
import java.util.Map;

public class SendWordsFromArrayList {
    AddWordEng add = new AddWordEng();

    public void send(HashMap<String,String> map){
        for(Map.Entry<String,String> entry : map.entrySet()){
            add.addUserP(entry.getKey(),entry.getValue());
        }
    }
}
