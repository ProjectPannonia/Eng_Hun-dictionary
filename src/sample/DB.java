package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    private final String JDBC_DRIVER =  "org.apache.derby.jdbc.EmbeddedDriver";
    private final String URL = "jdbc:derby:dic; create = true";
    private final String USERNAME = "";
    private final String PASSWORD = "";

    Connection conn = null;
    Statement cst = null;
    private DatabaseMetaData dmbd = null;
    private ResultSet rs = null;
    PreparedStatement ps = null;

    public DB(){
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("The bridge created!");
        } catch (SQLException e) {
            System.out.println("Problem when creating the bridge! " + e);
        }

        if(conn != null){
            try {
                cst = conn.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException e) {
                System.out.println("Problem when creating the statement! " + e);
            }
        }
        try {
            dmbd = conn.getMetaData();
        } catch (SQLException e) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, e);
        }
        try {
            rs = dmbd.getTables(null,"APP","DIC",null);
            if(!rs.next()){
                cst.execute("create table dic(eng varchar(20), address varchar(20))");
            }
        } catch (SQLException e) {
            System.out.println("Problem when creating the table(s)! " + e);
        }
    }

    public void addWordEng(String eng, String hun){
        String sql = "insert into dic values('"+ eng +"','"+ hun +"'')";
        try {
            cst.execute(sql);
            System.out.println("Sending to the database successfully!");
        } catch (SQLException e) {
            System.out.println("Valami baj van az addWord methoddal!");
            System.out.println("" + e);
        }
    }
}
