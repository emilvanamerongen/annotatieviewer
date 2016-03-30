/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.sql.* ;
import java.util.HashMap;

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
    public static void databaseget(Integer  type, Integer sequentienr, String adress, String database, String username, String password) throws SQLException {
        Connection conn = getConnection(adress,database,username,password);
        
        if (type == 1){
            System.out.println("getting sequence "+sequentienr+" from database...");
            ResultSet results = excecutequery(conn,"SELECT sequence FROM sequence WHERE sequence_id = "+sequentienr);
            while (results.next()) {
            Data_opslag_en_verwerking.setsequence(results.getString("sequence"));
        }    
            System.out.println("sequence imported");
        }
        if (type == 2){
            System.out.println("getting annotation for sequence "+sequentienr+" from database...");
            System.out.println("creating gene objects...");
            HashMap<Integer, Gene> newgenes = new HashMap<>();
            ResultSet results = excecutequery(conn,"SELECT * FROM gene WHERE sequence_sequence_id = "+sequentienr);
            while (results.next()) {
                Gene newgene = new Gene(results.getString("symbol"),Integer.parseInt(results.getString("gene_id")),results.getString("discription"),results.getString("score"));
                newgenes.put(Integer.parseInt(results.getString("gene_id")), newgene);
        } 
            System.out.println("created "+newgenes.size()+" gene objects");
            System.out.println("populating gene objects with features...");
            ResultSet results2 = excecutequery(conn,"SELECT * FROM features WHERE gene_sequence_sequence_id = "+sequentienr);
            while (results2.next()) {
                Feature newfeature = new Feature(Integer.parseInt(results2.getString("feature_id")),results2.getString("featuretype"),Integer.parseInt(results2.getString("start")),Integer.parseInt(results2.getString("stop")),Integer.parseInt(results2.getString("strand")));
                newgenes.get(Integer.parseInt(results2.getString("gene_gene_id"))).addFeature(newfeature);
            }
            System.out.println("annotation imported");
            Data_opslag_en_verwerking.setgenes(newgenes);
            newgenes.clear();
        }
        
    }

    public static Connection getConnection(String adress, String database, String username, String password) throws SQLException {
    System.out.println("trying to connect");
    Connection conn = null;
    conn = DriverManager.getConnection(
                   "jdbc:mysql://213.93.9.4:3306/blok7db",
                   "projectgroep","blaat1234");

 
    System.out.println("Connected to database");
    return conn;
}
    public static ResultSet excecutequery(Connection conn, String query) throws SQLException{
        System.out.println("--------db---------");
        System.out.println("executing query...");
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        System.out.println("values recieved...");
        System.out.println("------------------");
        return rs;
    }
}