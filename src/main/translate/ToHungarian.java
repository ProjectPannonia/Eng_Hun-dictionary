package main.translate;

import main.Word;
import main.creator.CreateArraylistFromDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ToHungarian {

    CreateArraylistFromDatabase createArraylist = new CreateArraylistFromDatabase();
    ArrayList<Word> list = createArraylist.getAllWord();

    public String translate(String eng){
        String hun = null;

        for(Word w : list){
            if(w.getEng().toLowerCase().equals(eng)){
                hun = w.getHun().toLowerCase();
            }
        }
        return hun;
    }
}
