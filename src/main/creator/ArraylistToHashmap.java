package main.creator;

import main.Word;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraylistToHashmap {

    public HashMap<String,String> create(ArrayList<Word> databaseWordsArrayList){
        HashMap<String,String> databaseHashmap = new HashMap<>();

        for (int i = 0; i < databaseWordsArrayList.size(); i++){
            String eng = databaseWordsArrayList.get(i).getEng();
            String hun = databaseWordsArrayList.get(i).getHun();
            databaseHashmap.put(eng,hun);
        }
        return databaseHashmap;
    }
}
