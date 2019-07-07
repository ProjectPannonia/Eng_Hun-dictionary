package sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateArraylistFromDatabase {
    DB db = new DB();

    public ArrayList<Word> getAllWord(){
        String sql = "select * from dic";
        ArrayList<Word> words;
        ResultSet rs = null;
        words = new ArrayList<>();
        try {
            rs = db.cst.executeQuery(sql);
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
