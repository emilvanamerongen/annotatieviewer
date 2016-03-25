/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotatieviewer;

/**
 *
 * @author EvertMichel
 */
public class Feature {
    private Integer feature_id;
    private String featuretype;
    private Integer start;
    private Integer stop;

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
}
