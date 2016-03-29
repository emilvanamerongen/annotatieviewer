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
}    
    public static File openFileChooser(){
    String filename = File.separator+"tmp";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        fileChooser.showOpenDialog(Annotation_viewer_GUI.jDialog1);
        File filepath = fileChooser.getSelectedFile();
        return filepath;
    }
    
    public static void readsequence(File importfile) throws IOException{
        Path filepath = Paths.get(importfile.getAbsolutePath());
        
        String newsequence = "";
        for (String line : Files.readAllLines(filepath)){
            if (line.contains(">")){
                
            }
            else if (line.matches("^[atcgATCG]+$")) {
                newsequence += line;
                        
            }
        }
        System.out.println(newsequence);
    }
    
}