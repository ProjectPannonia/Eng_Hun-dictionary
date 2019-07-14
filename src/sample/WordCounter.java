package sample;

import java.util.ArrayList;

public class WordCounter {
    DB db = new DB();

    CreateArraylistFromDatabase calfd = new CreateArraylistFromDatabase();
    public int WordCounter(){
        int count = 0;
        ArrayList<Word> words = calfd.getAllWord();
        for(Word w : words){
            count++;
        }
        return count;
    }
}
