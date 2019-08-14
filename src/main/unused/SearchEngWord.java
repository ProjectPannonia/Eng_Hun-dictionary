package main.unused;

import main.database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEngWord {
    DB db = new DB();
    PreparedStatement pst = null;
    Connection conn = db.getConn();

    public String SearchEngWord(String eng){
        String hun = "";
        try {
            String sql ="select hun from dictionary where eng = '"+ eng +"'";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                hun = rs.getString("hun");
            }
        } catch (SQLException e) {
            System.out.println("A lekérdezés sikerelen!");
            System.out.println("" + e);
        }
        return hun;
    }

}
