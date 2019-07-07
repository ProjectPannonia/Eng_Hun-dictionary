package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEngWord {
    DB db = new DB();
    PreparedStatement pst = null;


    public String SearchEngWord(String eng){
        String hun = "";
        try {
            String sql ="select hun from dictionary where eng = '"+ eng +"'";
            ResultSet rs = db.conn.createStatement().executeQuery(sql);
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
