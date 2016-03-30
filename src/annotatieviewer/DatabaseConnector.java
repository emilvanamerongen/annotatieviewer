/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.sql.* ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * database connector voor het ophalen van een DNA sequentie of annotatie uit een mysql database
 * @author Tjeerd
 */
public class DatabaseConnector{
    private static Statement stmt = null;
    private static ResultSet rs = null;
    /**
     * Haal een DNA sequentie of annotatie op uit de database
     * @param type 1: een sequentie moet worden opgehaald 2: er moet annotatie worden opgehaald
     * @param sequentienr welke sequentie er moet worden opgehaald (of annotatie voor worden opgehaald)
     * @param adress ip adres en port van de database
     * @param database database naam
     * @param username gebruikersnaam voor de database
     * @param password wachtwoord voor de database
     * @throws java.sql.SQLException
     */
    public static void databaseget(Integer  type, Integer sequentienr, String adress, String database, String username, String password) throws SQLException {
        Connection conn = getConnection(adress,database,username,password);
        // haal een sequentie op
        if (type == 1){
            System.out.println("getting sequence "+sequentienr+" from database...");
            // voer querry out
            ResultSet results = excecutequery(conn,"SELECT sequence FROM sequence WHERE sequence_id = "+sequentienr);
            int teller = 1;
            //haal het eerste resultaat uit de resultset
            while (results.next()) {
                if (teller == 1){
                // stuur de sequentie naar de data opslag
                Data_opslag_en_verwerking.setsequence(results.getString("sequence"));
                teller = 0;
                }
        }    
            System.out.println("sequence imported");
        }
        // haal annotatie op
        if (type == 2){
            System.out.println("getting annotation for sequence "+sequentienr+" from database...");
            System.out.println("creating gene objects...");
            // maak een tijdelijke list voor het opslaan van de gen objecten
            List<Gene> newgenes = new ArrayList<Gene>();
            // voer querry uit
            ResultSet results = excecutequery(conn,"SELECT * FROM gene WHERE sequence_sequence_id = "+sequentienr);
            // maak voor elk resultaat een gene object en voeg deze toe aan de newgenes list 
            while (results.next()) {
                Gene newgene = new Gene(results.getString("symbol"),Integer.parseInt(results.getString("gene_id")),results.getString("discription"),results.getString("score"));
                newgenes.add(newgene);
        } 
            System.out.println("created "+newgenes.size()+" gene objects");
            System.out.println("populating gene objects with features...");
            // haal features op voor alle genen
            ResultSet results2 = excecutequery(conn,"SELECT * FROM features WHERE gene_sequence_sequence_id = "+sequentienr);
            // voor elk resultaat maak een feature object en voeg deze toe aan het juiste gene object
            while (results2.next()) {
                Feature newfeature = new Feature(Integer.parseInt(results2.getString("feature_id")),results2.getString("featuretype"),Integer.parseInt(results2.getString("start")),Integer.parseInt(results2.getString("stop")),Integer.parseInt(results2.getString("strand")));
                newgenes.get(Integer.parseInt(results2.getString("gene_gene_id"))-1).addFeature(newfeature);
            }
            System.out.println("annotation imported");
            // stuur de nieuwe gene list naar de data opslag
            Data_opslag_en_verwerking.setgenes(newgenes);
            newgenes.clear();
        }
        
    }

    /**
     * maak verbinding met de database, hiervoor word de mysql connector library gebruikt
     * @param adress ip adres en port van de database
     * @param database database naam
     * @param username gebruikersnaam voor de database
     * @param password wachtwoord voor de database
     * @return
     * @throws SQLException
     */
    public static Connection getConnection(String adress, String database, String username, String password) throws SQLException {
    System.out.println("trying to connect");
    Connection conn = null;
    conn = DriverManager.getConnection(
                   "jdbc:mysql://213.93.9.4:3306/blok7db",
                   "projectgroep","blaat1234");

 
    System.out.println("Connected to database");
    return conn;
}

    /**
     * voer de opgegeven query uit het return de resultaten
     * @param conn de connectie die is gemaakt met de database
     * @param query de query die moet worden uitgevoerd
     * @return
     * @throws SQLException
     */
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