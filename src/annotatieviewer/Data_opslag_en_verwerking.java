/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.util.HashMap;

/**
 *
 * @author emilvanamerongen
 */
public class Data_opslag_en_verwerking {

    
    public static String sequence = "";
    public static HashMap<Integer,Gene> genes = new HashMap<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
    }
    public static void init(){
        new Annotation_viewer_GUI().setVisible(true);
    }
    public static void setsequence(String newsequence){
        sequence = newsequence;
        Annotation_viewer_GUI.visualise();
    }
    public static void setgenes(HashMap<Integer,Gene> newgenes){
        genes = newgenes;
        Annotation_viewer_GUI.visualise();
    }
    
}
