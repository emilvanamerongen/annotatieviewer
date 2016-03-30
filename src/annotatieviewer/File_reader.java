/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;

/**
 * lees een bestand met een DNA sequentie of annotatie in
 * @author Emil
 */
public class File_reader {

    /**
     * start met het lezen van het bestand
     * @param type 1: een sequentie inlezen 2: een annotatie (gff) bestand inlezen
     * @throws IOException 
     */
    public static void readfile(Integer type) throws IOException{
       File importfile = openFileChooser();
       if (type == 1){           
           readsequence(importfile);
       }
       if (type == 2){
           readannotation(importfile);
          
       }
}    

    /**
     * creer een filechooser voor het kiezen van je bestand
     * @return je gekozen bestand
     */
    public static File openFileChooser(){
    String filename = File.separator+"tmp";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        fileChooser.showOpenDialog(Annotation_viewer_GUI.jDialog1);
        File filepath = fileChooser.getSelectedFile();
        return filepath;
    }
    
    /**
     * lees de DNA sequentie uit je bestand
     * @param importfile je gekozen bestand 
     * @throws IOException
     */
    public static void readsequence(File importfile) throws IOException{
        System.out.println("trying to read sequence file....");
        Path filepath = Paths.get(importfile.getAbsolutePath());
        
        String newsequence = "";
        for (String line : Files.readAllLines(filepath)){
            //filter de header weg
            if (line.contains(">")){         
            }
            //als er dna op de regel staat voeg deze toe aan de nieuwe sequentie
            else if (line.matches("^[atcgATCG]+$")) {
                newsequence += line;
                        
            }
        }
        System.out.println("new sequence loaded....");
        //stuur de nieuwe sequentie naar de data opslag
        Data_opslag_en_verwerking.setsequence(newsequence);
    }
    
    /**
     *
     * @param importfile
     * @throws IOException
     */
    public static void readannotation(File importfile) throws IOException{
        try{
        System.out.println("trying to read gff annotation file....");
        // haal het bestandspad van je bestand op
        Path filepath = Paths.get(importfile.getAbsolutePath());
        // locale variabelen
        Boolean active = false;
        int genenumber = 0;
        int featurenumber = 0;
        String genename = "";
        String discription = "";
        String score = ""; 
        String featuretype = "";
        String start = "";
        String stop = "";
        int strand = 0;
        // tijdelijke opslag van features en genes
        HashMap<Integer, Feature> featuretemp = new HashMap<>();
        List<Gene> newgenes = new ArrayList<Gene>();
        // loop over alle regels van het bestand en sla alle nuttige informatie op
        for (String line : Files.readAllLines(filepath)){
            if (line.contains("start gene")){
                genenumber += 1;
                genename = line.split(" ")[3];          
        }
            if (line.contains("\tgene\t")){
                String[] linesplit = line.split("\t");
                discription = linesplit[8];
                score = linesplit[5];
                newgenes.add(new Gene(genename,genenumber,discription,score));
            }
            if (line.contains("SD\t")){
                featurenumber += 1;
                String[] linesplit = line.split("\t");
                featuretype = linesplit[2];
                start = linesplit[3];
                stop = linesplit[4];

                if (linesplit[6].contains("-")){
                    strand = 0;
                }
                else{
                    strand = 1;
                }
                Feature newfeature = new Feature(featurenumber,featuretype,Integer.parseInt(start),Integer.parseInt(stop),strand);
                newgenes.get(genenumber-1).addFeature(newfeature);
            }
            if (line.contains("coding")){               
                featuretemp.clear();
                featurenumber = 0;
            }
        }
        System.out.println("loaded "+newgenes.size()+" sequences...");
        //stuur de nieuwe genen naar de data opslag
        Data_opslag_en_verwerking.setgenes(newgenes);
        // clear de temp gene arraylist
        newgenes.clear();
        }
        catch (java.lang.NullPointerException ex){
            System.out.println("ERROR reading file");
        }
        catch (IOException ex){
            System.out.println("ERROR opening file");
        }
    }
}