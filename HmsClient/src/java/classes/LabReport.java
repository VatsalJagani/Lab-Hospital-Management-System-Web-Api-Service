/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author VATSAL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabReport {
    public String pid;
    public Double checkin_no,laboratory_no,glucose,hemoglobin,rdc,wbc,afp,psa,cost;
    public Date lab_date;
      
      
     public String getPid() {
       return pid;
    }
     public Double getCheckinNo() {
       return checkin_no;
    }
     public Double getLaboratoryNo() {
       return laboratory_no;
    }
     public Double getGlucose() {
       return glucose;
    }
     public Double getHemoglobin() {
       return hemoglobin;
    }
     public Double getRdc() {
       return rdc;
    }
     public Double getWbc() {
       return wbc;
    }
     public Double getAfp() {
       return afp;
    }
     public Double getPsa() {
       return psa;
    }
     public Double getCost() {
       return cost;
    }
     public Date getLabDate(){
          
            return lab_date;
        
    }
}
