/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.util.HashMap;


/**
 *
 * @author Emil
 */
public class Sequencetools {
    
    public static HashMap<String,String> Translator = new HashMap<>();
    
    public static String complement(String dna){
        System.out.println("generating complement DNA...");
        String comp = null;
        try{
        comp = "";
         for (int k = 0; k < dna.length(); k++){
        if (dna.charAt(k) == 'A'){
        comp = comp + 'T';}
        else if (dna.charAt(k) == 'T'){
        comp = comp + 'A';}
        else if (dna.charAt(k) == 'C'){
        comp = comp + 'G';}
        else if (dna.charAt(k) == 'G'){
        comp = comp + 'C';}
        else {
            comp = comp + dna.charAt(k);
        }
    }
        }
        catch(java.lang.NullPointerException ex){
            System.out.println("ERROR making complement");
        }

        return comp;
 }
        public static String TranslateSequence(String sequence){
        System.out.println("translating DNA sequence to Aminoacid sequence...");
        String NewSequence="";
        int Nucleotides =sequence.length()/3;
        Translator.put("atg", "-M-");
        Translator.put("ttt", "-F-");
        Translator.put("ttc", "-F-");
        Translator.put("tta", "-L-");
        Translator.put("ttg", "-L-");
        Translator.put("ctt", "-L-");
        Translator.put("cta", "-L-");
        Translator.put("ctg", "-L-");
        Translator.put("att", "-I-");
        Translator.put("atc", "-I-");
        Translator.put("ata", "-I-");
        Translator.put("gta", "-V-");
        Translator.put("gtg", "-V-");
        Translator.put("gtt", "-V-");
        Translator.put("gtc", "-V-");
        Translator.put("tct", "-S-");
        Translator.put("tca", "-S-");
        Translator.put("tcg", "-S-");
        Translator.put("tcc", "-S-");
        Translator.put("cct", "-P-");
        Translator.put("cca", "-P-");
        Translator.put("ccg", "-P-");
        Translator.put("ccc", "-P-");
        Translator.put("act", "-T-");
        Translator.put("acg", "-T-");
        Translator.put("acc", "-T-");
        Translator.put("aca", "-T-");
        Translator.put("gct", "-A-");
        Translator.put("gca", "-A-");
        Translator.put("gcc", "-A-");
        Translator.put("gcg", "-A-");
        Translator.put("tat", "-Y-");
        Translator.put("tac", "-Y-");
        Translator.put("taa", "STP");
        Translator.put("tag", "STP");
        Translator.put("cat", "-H-");
        Translator.put("cac", "-H-");
        Translator.put("caa", "-Q-");
        Translator.put("cag", "-Q-");
        Translator.put("aat", "-N-");
        Translator.put("aac", "-N-");
        Translator.put("aaa", "-K-");
        Translator.put("aag", "-K-");
        Translator.put("gat", "-D-");
        Translator.put("gac", "-D-");
        Translator.put("gaa", "-E-");
        Translator.put("gag", "-E-");
        Translator.put("tgt", "-C-");
        Translator.put("tgc", "-C-");
        Translator.put("uta", "STP");
        Translator.put("tgg", "-W-");
        Translator.put("cgt", "-R-");
        Translator.put("cgc", "-R-");
        Translator.put("cgg", "-R-");
        Translator.put("cga", "-R-");
        Translator.put("agt", "-S-");
        Translator.put("agc", "-S-");
        Translator.put("aga", "-R-");
        Translator.put("agg", "-R-");
        Translator.put("ggt", "-G-");
        Translator.put("gga", "-G-");
        Translator.put("ggc", "-G-");
        Translator.put("ggg", "-G-");
        for(int i=0;i<Nucleotides;i++){
            String codon = (String) sequence.subSequence(i, i+3);
            if (Translator.get(codon)==null){
                NewSequence+="***";
            }else{
                NewSequence+=Translator.get(codon);
            }
            }
        return NewSequence;
    }
        
    public static HashMap<Integer, String> createsubstrings(String sequence){
        System.out.println("splitting sequence in 200 base substrings...");
        HashMap<Integer, String> newsubstrings = new HashMap<>();
        int substringnumber = 0;
        String tempchar = "";
        for (Character character : sequence.toCharArray()){
            tempchar += ""+character;
            if (tempchar.length() == 200){
                newsubstrings.put(substringnumber, tempchar.toUpperCase());
                substringnumber +=1;
                tempchar ="";     
            }
        if (tempchar != ""){
            newsubstrings.put(substringnumber, tempchar.toUpperCase());
        }
        }
        return newsubstrings;
        
    }
        
}
