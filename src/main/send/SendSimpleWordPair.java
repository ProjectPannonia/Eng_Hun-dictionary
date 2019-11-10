package main.send;

import main.database.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendSimpleWordPair {
    DB db = new DB();
    PreparedStatement preparedStatement = null;
    Connection connection = db.getConnection();

    public void addUserP(String eng, String hun){
        try {
            //Paraméterek átadása nem közvetlen, így véd a hibás adatbeviteltől
            String sql = "insert into dic values(?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            //Típusellenőrzés
            preparedStatement.setString(1,eng);
            preparedStatement.setString(2,hun);
            preparedStatement.execute();
            System.out.println("Adatküldés sikeres a preparedStatement-el");
        } catch (SQLException e) {
            System.out.println("Adatküldés sikertelen a preparedStatement-el");
            System.out.println("" + e);
        }
    }
}
