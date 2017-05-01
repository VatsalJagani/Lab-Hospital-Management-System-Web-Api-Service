/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author VATSAL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {
    public double place_id;
    public String place_type,description;
    public Double shift1,shift2,shift3;
    
    public double getPlaceId(){
        return place_id;
    }
    public String getPlaceType(){
        return place_type;
    }
    public String getDescription(){
        return description;
    }
    public Double getShift1(){
        return shift1;
    }
    public Double getShift2(){
        return shift2;
    }
    public Double getShift3(){
        return shift3;
    }
}
