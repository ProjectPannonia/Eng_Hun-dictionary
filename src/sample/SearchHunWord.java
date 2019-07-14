package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchHunWord {
    DB db = new DB();
    PreparedStatement pst = null;

    public String SearchHunWord(String hun){
        String eng = "";
        try {
            String sql = "select eng from dictionary where hun = '"+ hun+"'";
            ResultSet rs = db.conn.createStatement().executeQuery(sql);
            while(rs.next()){
                eng = rs.getString("eng");
            }
        } catch (SQLException e) {
            System.out.println("A lekérdezés sikertelen! " + e);
        }
        return eng;
    }

}
