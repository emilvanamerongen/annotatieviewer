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
 * de hoofdclass met opslag en verwerking van gegevens
 * @author emilvanamerongen, (Tjeerd van der Veen)
 */
public class Data_opslag_en_verwerking {

    /**
     *  hoofdopslag van de huidige DNA sequentie
     */
    public static String sequence = "empty";

    /**
     *  opslag van substrings van de huidige DNA sequentie
     */
    public static HashMap<Integer, String> substrings = new HashMap<>();

    /**
     *  opslag van de forward substrings van de huidige aminozuur sequentie
     */
    public static HashMap<Integer, String> aminosubstrings = new HashMap<>();

    /**
     *  opslag van de reverse substrings van de huidige aminozuur sequentie
     */
    public static HashMap<Integer, String> aminosubstringsreverse = new HashMap<>();

    /**
     *  opslag van annotatie in een arraylist met gene objecten (gekozen voor arraylist omdat hashmaps bugs veroorzaakte)
     */
    public static List<Gene> genes = new ArrayList<Gene>();

    /**
     *  hoofdopslag van de huidige aminozuur sequentie
     */
    public static String AminoSequence;

    /**
     *  oplag van de reverse aminozuur sequentie
     */
    public static String AminoSequencereverse;

    /**
     *  keuze tussen DNA sequentie weergave of aminozuursequentie weergave, opgeslagen als boolean
     */
    public static Boolean dnaorprotein = false;
    
    /**
     * 
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
     * sla een nieuwe sequentie op en verwerk deze naar verschillende type opslag objecten
     * @param newsequence die nieuwe DNA sequentie
     */
    public static void setsequence(String newsequence){
        // filter alle nextline en spaties uit de DNA sequentie
        sequence = newsequence.replace("\n", "").replace(" ", "").replace("\r","");
        // maak substrings van de DNA sequentie 
        substrings = Sequencetools.createsubstrings(sequence);
        // vertaal de sequentie naar aminozuren
        AminoSequence = Sequencetools.TranslateSequence(sequence);
        // vertaal de complementaire sequentie naar aminozuren
        AminoSequencereverse = Sequencetools.TranslateSequence(Sequencetools.complement(sequence));
        // maak substrings van de aminozuursequentie
        aminosubstrings = Sequencetools.createsubstrings(AminoSequence);
        // maak substrings van de complementaire aminozuursequentie
        aminosubstringsreverse = Sequencetools.createsubstrings(AminoSequencereverse); 
        // visualiseer de nieuwe data
        Annotation_viewer_GUI.visualise();
    }
        

    /**
     * sla nieuwe annotatie gene objecten op in de Arraylist met genen
     * @param newgenes nieuwe list met genen die opgeslagen moeten worden
     */
    public static void setgenes(List<Gene> newgenes){
        genes.addAll(newgenes);
        // visualiseer de nieuwe data
        Annotation_viewer_GUI.visualise();
    }    
}
