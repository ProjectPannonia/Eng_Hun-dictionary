package main;

import main.creator.CreateArraylistFromDatabase;
import main.database.DB;

import java.util.ArrayList;

public class WordCounter {
    DB db = new DB();
    CreateArraylistFromDatabase arraylist = new CreateArraylistFromDatabase();

    public int WordCounter(){
        int count = 0;
        ArrayList<Word> words = arraylist.getAllWord();
        for(Word w : words){
            count++;
        }
        return count;
    }
}
