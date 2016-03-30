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
 * een opslag object voor genen
 * @author Emil
 */
public class Gene {
    private String symbol;
    private int gene_id;
    private String discription;
    private String score;
    private List<Feature> features = new ArrayList<Feature>();

    /**
     * constructor opslag object voor genen
     * @param newsymbol nieuwe naam voor het gen
     * @param newgene_id nieuw id voor het gen
     * @param newdiscription nieuwe beschrijving van het gen
     * @param newscore nieuwe score van het gen
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
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
    
    /**
     *
     * @param newfeature
     */
    public void addFeature(Feature newfeature){
        this.features.add(newfeature);
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
