/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

/**
 * een opslag object voor features
 * @author Emil
 */
public class Feature {
    private Integer feature_id;
    private String featuretype;
    private Integer start;
    private Integer stop;
    private Integer strand;

    /**
     * constructor opslag object voor features
     * @param newfeature_id een nieuw feature id 
     * @param newfeaturetype een nieuw featuretype bv. start_codon
     * @param newstart een nieuwe start positie voor de feature
     * @param newstop een nieuwe stop positie voor de feature
     * @param newstrand forward of reverse strand (1 of 0)
     */
    public Feature(Integer newfeature_id, String newfeaturetype, Integer newstart, Integer newstop, Integer newstrand){
        this.feature_id = newfeature_id;
        this.featuretype = newfeaturetype;
        this.start = newstart;
        this.stop = newstop;
        this.strand = newstrand;
}

    /**
     * @return the feature_id
     */
    public Integer getFeature_id() {
        return feature_id;
    }

    /**
     * @param feature_id the feature_id to set
     */
    public void setFeature_id(Integer feature_id) {
        this.feature_id = feature_id;
    }

    /**
     * @return the featuretype
     */
    public String getFeaturetype() {
        return featuretype;
    }

    /**
     * @param featuretype the featuretype to set
     */
    public void setFeaturetype(String featuretype) {
        this.featuretype = featuretype;
    }

    /**
     * @return the start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * @return the stop
     */
    public Integer getStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(Integer stop) {
        this.stop = stop;
    }

    /**
     * @return the strand
     */
    public Integer getStrand() {
        return strand;
    }

    /**
     * @param strand the strand to set
     */
    public void setStrand(Integer strand) {
        this.strand = strand;
    }
}
