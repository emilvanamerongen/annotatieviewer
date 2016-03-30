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

    
    public static String sequence = "empty";
    public static HashMap<Integer,Gene> genes = new HashMap<>();
    public static HashMap<String,String> Translator = new HashMap<>(); //hij wou ze niet achter elkaar, dat gaf een foutmelding
    public static String AmminoSequence;
    
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
        sequence = newsequence.replace(" ", "");
        AmminoSequence=TranslateSequence(sequence);
        Annotation_viewer_GUI.visualise();
    }
    public static String TranslateSequence(String sequence){
        String NewSequence="";
        int Nucleotides =sequence.length()/3;
        Translator.put("atg", "met");
        Translator.put("ttt", "phe");
        Translator.put("ttc", "phe");
        Translator.put("tta", "leu");
        Translator.put("ttg", "leu");
        Translator.put("ctt", "leu");
        Translator.put("cta", "leu");
        Translator.put("ctg", "leu");
        Translator.put("att", "ile");
        Translator.put("atc", "ile");
        Translator.put("ata", "ile");
        Translator.put("gta", "val");
        Translator.put("gtg", "val");
        Translator.put("gtt", "val");
        Translator.put("gtc", "val");
        for(int i=0;i<Nucleotides;i++){
            String codon = (String) sequence.subSequence(i, i+3);
            AmminoSequence+=Translator.get(codon);
            }
        System.out.println(AmminoSequence);
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
