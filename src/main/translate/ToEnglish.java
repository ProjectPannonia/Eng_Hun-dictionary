package main.translate;

import main.Word;
import main.creator.CreateArraylistFromDatabase;

import java.util.ArrayList;

public class ToEnglish {
    CreateArraylistFromDatabase createArrayList = new CreateArraylistFromDatabase();
    ArrayList<Word> list = createArrayList.getAllWord();

    public String translate(String hun){
        String en = null;
            for(Word w : list){
                if(w.getHun().equals(hun)){
                    en = w.getEng().toLowerCase();
                }
            }
        return en;
    }
}
