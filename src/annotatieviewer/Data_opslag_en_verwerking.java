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

    
    public String sequence;
    public HashMap<Integer,Gene> genes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
    }
    public static void init(){
        new Annotation_viewer_GUI().setVisible(true);
    }
    
}
