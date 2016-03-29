/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.sql.* ;
import java.math.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tjeerd
 */
public class DatabaseConnector{
    private static Statement stmt = null;
    private static ResultSet rs = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = getConnection();
        ResultSet results = excecutequery(conn);
        while (results.next()) {
        System.out.println(results.getString("discription"));
}
    }
    
    
    public static Connection getConnection() throws SQLException {
    System.out.println("trying to connect");
    Connection conn = null;
    conn = DriverManager.getConnection(
                   "jdbc:mysql://213.93.9.4:3306/blok7db",
                   "projectgroep","blaat1234");

 
    System.out.println("Connected to database");
    return conn;
}
    public static ResultSet excecutequery(Connection conn) throws SQLException{
        System.out.println("executing query...");
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM gene");
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("values recieved...");
        return rs;
    }
}