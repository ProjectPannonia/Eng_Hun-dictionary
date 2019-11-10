package main.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private final String JDBC_DRIVER =  "org.apache.derby.jdbc.EmbeddedDriver";
    private final String URL = "jdbc:derby:dic; create = true";
    private final String USERNAME = "";
    private final String PASSWORD = "";

    Connection connection = null;
    Statement statement = null;
    private DatabaseMetaData databaseMetaData = null;
    private ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    public Connection getConnection() {
        return this.connection;
    }
    public Statement getStatement(){
        return this.statement;
    }



    public DB(){
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("The bridge created!");
        } catch (SQLException e) {
            System.out.println("Problem when creating the bridge! " + e);
        }

        if(connection != null){
            try {
                statement = connection.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException e) {
                System.out.println("Problem when creating the statement! " + e);
            }
        }

        try {
            databaseMetaData = connection.getMetaData();
        } catch (SQLException e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            resultSet = databaseMetaData.getTables(null,"APP","DIC",null);
            if(!resultSet.next()){
                statement.execute("create table dic(eng varchar(20),hun varchar(20))");
            }
        } catch (SQLException e) {
            System.out.println("Problem when creating the table(s)! " + e);
        }

    }
}
