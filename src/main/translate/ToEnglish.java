package main.translate;

import main.Word;

public class ToEnglish implements Translate{

    @Override
    public String translate(String searchedWord) {
        String en = null;
        for(Word w : list){
            if(w.getHun().equals(searchedWord)){
                en = w.getEng().toLowerCase();
            }
        }
        return en;
    }
}
