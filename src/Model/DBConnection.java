/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    public Connection conn=null;
    public Connection getConn() throws SQLException {
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1522:orcl3";
            conn = DriverManager.getConnection(url,"testcon","admin");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }


    private static DBConnection instance=null;
    public static DBConnection getInstance() throws SQLException
    {
        if(instance==null)
            instance=new DBConnection();
        return instance;
    }
    private DBConnection(){}

    public void getClose(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
