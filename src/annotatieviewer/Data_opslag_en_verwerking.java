/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.util.HashMap;

/**
 *
 * @author emilvanamerongen, (Tjeerd van der Veen)
 */
public class Data_opslag_en_verwerking {

    
    public static String sequence = "";
    public static HashMap<Integer,Gene> genes = new HashMap<>();
    public static String AmminoSequence;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
    }
    /**
     * initiates the GUI
     */
    public static void init(){
        new Annotation_viewer_GUI().setVisible(true);
    }
    /**
     * sets the given sequence in the annotation viewer
     * @param newsequence give the a sequence
     */
    public static void setsequence(String newsequence){
        sequence = newsequence;
        Annotation_viewer_GUI.visualise();
    }
    public static String TranslateSequence(String sequence){
        String NewSequence="";
        
        return NewSequence;
    }
    /**
     * sets the genes in the annotiation viewer
     * @param newgenes 
     */
    public static void setgenes(HashMap<Integer,Gene> newgenes){
        genes = newgenes;
        Annotation_viewer_GUI.visualise();
    }
    
}
