package main.unused;

import main.database.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchHunWord {
    DB db = new DB();
    Connection conn = db.getConnection();
    public String SearchHunWord(String hun){
        String eng = "";
        try {
            String sql = "select eng from dictionary where hun = '"+ hun+"'";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                eng = rs.getString("eng");
            }
        } catch (SQLException e) {
            System.out.println("A lekérdezés sikertelen! " + e);
        }
        return eng;
    }

}
