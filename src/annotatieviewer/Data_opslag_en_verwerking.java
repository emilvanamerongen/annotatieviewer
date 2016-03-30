/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emilvanamerongen, (Tjeerd van der Veen)
 */
public class Data_opslag_en_verwerking {

    
    public static String sequence = "empty";
    public static HashMap<Integer, String> substrings = new HashMap<>();
    public static HashMap<Integer, String> aminosubstrings = new HashMap<>();
    public static HashMap<Integer, String> aminosubstringsreverse = new HashMap<>();
    public static List<Gene> genes = new ArrayList<Gene>();
    public static String AminoSequence;
    public static String AminoSequencereverse;
    public static Boolean dnaorprotein = false;
    
    /**
     * initiates the project
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
        sequence = newsequence.replace("\n", "").replace(" ", "").replace("\r","");
        substrings = Sequencetools.createsubstrings(sequence);
        AminoSequence = Sequencetools.TranslateSequence(sequence);
        AminoSequencereverse = Sequencetools.TranslateSequence(Sequencetools.complement(sequence));
        aminosubstrings = Sequencetools.createsubstrings(AminoSequence);
        aminosubstringsreverse = Sequencetools.createsubstrings(AminoSequencereverse); 
        Annotation_viewer_GUI.visualise();
    }
        

    /**
     * sets the genes in the annotiation viewer
     * @param newgenes 
     */
    public static void setgenes(List<Gene> newgenes){
        genes.addAll(newgenes);
        Annotation_viewer_GUI.visualise();
    }    
}
