package main.translate;

import main.Word;

public class ToHungarian implements Translate {

    @Override
    public String translate(String searchedWord) {
        String hun = null;

        for(Word w : list){
            if(w.getEng().toLowerCase().equals(searchedWord)){
                hun = w.getHun().toLowerCase();
            }
        }
        return hun;
    }
}
