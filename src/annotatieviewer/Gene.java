/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

import java.util.HashMap;

/**
 *
 * @author EvertMichel
 */
public class Gene {
    private String symbol;
    private int gene_id;
    private String discription;
    private String score;
    private HashMap<Integer,Feature> features = new HashMap<>();

    /**
     *
     * @param newsymbol
     * @param newgene_id
     * @param newdiscription
     * @param newscore
     */
    public Gene(String newsymbol,Integer newgene_id,String newdiscription,String newscore) {
        this.symbol = newsymbol;
        this.gene_id = newgene_id;
        this.discription = newdiscription;
        this.score = newscore;
    }
    /**
     * @return the gene_id
     */
    public int getGene_id() {
        return gene_id;
    }

    /**
     * @param gene_id the gene_id to set
     */
    public void setGene_id(int gene_id) {
        this.gene_id = gene_id;
    }

    /**
     * @return the discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription the discription to set
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * @return the score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * @return the features
     */
    public HashMap<Integer,Feature> getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(HashMap<Integer,Feature> features) {
        this.features = features;
    }
    
    /**
     *
     * @param newfeature
     */
    public void addFeature(Feature newfeature){
        Integer featureid = newfeature.getFeature_id();
        this.features.put(featureid, newfeature);
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol the symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
