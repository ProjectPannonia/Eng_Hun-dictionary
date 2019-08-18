package main.translate;

import main.Word;
import main.creator.CreateArraylistFromDatabase;

import java.util.ArrayList;

public interface Translate {
    CreateArraylistFromDatabase createArraylist = new CreateArraylistFromDatabase();
    ArrayList<Word> list = createArraylist.getAllWord();
    public String translate(String searchedWord);

}
