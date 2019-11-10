package main.creator;

import main.database.DB;
import main.Word;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CreateArraylistFromDatabase {
    DB db = new DB();
    Statement statement = db.getStatement();

    public ArrayList<Word> getAllWord(){
        String sql = "select * from dic";
        ArrayList<Word> words;
        ResultSet rs = null;
        words = new ArrayList<>();
        try {
            rs = statement.executeQuery(sql);
            while(rs.next()){
                Word actualWord = new Word(rs.getString("eng"),rs.getString("hun"));
                words.add(actualWord);
            }
        } catch (SQLException e) {
            System.out.println("Problem with the getAllWord method! " + e);
        }
        return words;
    }
}
