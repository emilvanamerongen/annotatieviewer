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
import java.util.HashMap;
import javax.swing.JFileChooser;

/**
 *
 * @author EvertMichel
 */
public class File_reader {
    public static void readfile(Integer type) throws IOException{
       File importfile = openFileChooser();
       if (type == 1){           
           readsequence(importfile);
       }
       if (type == 2){
           readannotation(importfile);
          
       }
}    
    public static File openFileChooser(){
    String filename = File.separator+"tmp";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        fileChooser.showOpenDialog(Annotation_viewer_GUI.jDialog1);
        File filepath = fileChooser.getSelectedFile();
        return filepath;
    }
    
    public static void readsequence(File importfile) throws IOException{
        System.out.println("trying to read sequence file....");
        Path filepath = Paths.get(importfile.getAbsolutePath());
        
        String newsequence = "";
        for (String line : Files.readAllLines(filepath)){
            if (line.contains(">")){
                
            }
            else if (line.matches("^[atcgATCG]+$")) {
                newsequence += line;
                        
            }
        }
        System.out.println("new sequence loaded....");
        Data_opslag_en_verwerking.setsequence(newsequence);
    }
    
    public static void readannotation(File importfile) throws IOException{
        System.out.println("trying to read gff annotation file....");
        Path filepath = Paths.get(importfile.getAbsolutePath());
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
        HashMap<Integer, Feature> featuretemp = new HashMap<>();
        HashMap<Integer, Gene> newgenes = new HashMap<>();
        for (String line : Files.readAllLines(filepath)){
            if (line.contains("start gene")){
                genenumber += 1;
                genename = line.split(" ")[3];          
        }
            if (line.contains("\tgene\t")){
                String[] linesplit = line.split("\t");
                discription = linesplit[8];
                score = linesplit[5];
                newgenes.put(genenumber, new Gene(genename,genenumber,discription,score));
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
                newgenes.get(genenumber).addFeature(newfeature);
            }
            if (line.contains("coding")){               
                featuretemp.clear();
                featurenumber = 0;
            }
        }
        System.out.println("loaded "+newgenes.size()+" sequences...");
        Data_opslag_en_verwerking.setgenes(newgenes);
        System.out.println(newgenes.get(5).getSymbol());
        System.out.println(newgenes.get(5).getFeatures().get(1).getStart());
    }
}