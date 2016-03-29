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
        for (String line : Files.readAllLines(filepath)){
            if (active){
                String[] splitline = line.split("\t");
                int feature_id = featurenumber;
                featurenumber += 1;
                
                        
            }
            if (line.contains("\tgene\t")){
                active = true;
                String[] splitline = line.split("\t");
                int geneid = genenumber;
                genenumber += 1;
                String discription = splitline[0];
                int score = Integer.parseInt(splitline[5]);
                HashMap<Integer, Feature> features = new HashMap<>();
            }
            if (line.contains("stop")){
                active = false;
            }
        }
        System.out.println("new sequence loaded....");
    }
}