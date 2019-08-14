package main.send;

import main.database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendSimpleWordPair {
    DB db = new DB();
    PreparedStatement ps = null;
    Connection conn = db.getConn();

    public void addUserP(String eng, String hun){
        try {
            //Paraméterek átadása nem közvetlen, így véd a hibás adatbeviteltől
            String sql = "insert into dic values(?, ?)";
            ps = conn.prepareStatement(sql);
            //Típusellenőrzés
            ps.setString(1,eng);
            ps.setString(2,hun);
            ps.execute();
            System.out.println("Adatküldés sikeres a preparedStatement-el");
        } catch (SQLException e) {
            System.out.println("Adatküldés sikertelen a preparedStatement-el");
            System.out.println("" + e);
        }
    }
}
