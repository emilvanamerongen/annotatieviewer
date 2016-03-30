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
    public static HashMap<Integer, String> substrings = new HashMap<>();
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
        sequence = newsequence.replace("\n", "");
        System.out.println("splitting sequence in 200 base substrings...");
        int teller = 0;
        int substringnumber = 0;
        String tempchar = "";
        for (Character character : sequence.toCharArray()){
            tempchar += ""+character;
            if (teller == 200){
                teller = 0;
                substrings.put(substringnumber, tempchar);
                substringnumber +=1;
                tempchar ="";     
            }
            teller+=1;
        if (tempchar != ""){
            substrings.put(substringnumber, tempchar);
        } 
        Annotation_viewer_GUI.visualise();
    }
    }
    public static void TranslateSequence(){     
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
        Translator.put("tct", "ser");
        Translator.put("tca", "ser");
        Translator.put("tcg", "ser");
        Translator.put("tcc", "ser");
        Translator.put("cct", "pro");
        Translator.put("cca", "pro");
        Translator.put("ccg", "pro");
        Translator.put("ccc", "pro");
        Translator.put("act", "thr");
        Translator.put("acg", "thr");
        Translator.put("acc", "thr");
        Translator.put("aca", "thr");
        Translator.put("gct", "ala");
        Translator.put("gca", "ala");
        Translator.put("gcc", "ala");
        Translator.put("gcg", "ala");
        Translator.put("tat", "tyr");
        Translator.put("tac", "tyr");
        Translator.put("taa", "STP");
        Translator.put("tag", "STP");
        Translator.put("cat", "his");
        Translator.put("cac", "his");
        Translator.put("caa", "gln");
        Translator.put("cag", "gln");
        Translator.put("aat", "asn");
        Translator.put("aac", "asn");
        Translator.put("aaa", "lys");
        Translator.put("aag", "lys");
        Translator.put("gat", "asp");
        Translator.put("gac", "asp");
        Translator.put("gaa", "glu");
        Translator.put("gag", "glu");
        Translator.put("tgt", "cys");
        Translator.put("tgc", "cys");
        Translator.put("uta", "STP");
        Translator.put("tgg", "trp");
        Translator.put("cgt", "arg");
        Translator.put("cgc", "arg");
        Translator.put("cgg", "arg");
        Translator.put("cga", "arg");
        Translator.put("agt", "ser");
        Translator.put("agc", "ser");
        Translator.put("aga", "arg");
        Translator.put("agg", "arg");
        Translator.put("ggt", "gly");
        Translator.put("gga", "gly");
        Translator.put("ggc", "gly");
        Translator.put("ggg", "gly");
        for(int i=0;i<Nucleotides;i++){
            String codon = (String) sequence.subSequence(i, i+3);
            if (Translator.get(codon)==null){
                AmminoSequence+="***";
            }else{
                AmminoSequence+=Translator.get(codon);
            }
            }
        AmminoSequence = NewSequence;
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
