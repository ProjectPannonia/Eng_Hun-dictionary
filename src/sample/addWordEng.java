package sample;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class addWordEng {
    DB db = new DB();
    Word w = new Word();
    PreparedStatement ps = null;
    Statement cst = null;

    public void addUserP(String eng, String hun){
        try {
            //Paraméterek átadása nem közvetlen, így véd a hibás adatbeviteltől
            String sql = "insert into dic values(?, ?)";
            ps = db.conn.prepareStatement(sql);
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
