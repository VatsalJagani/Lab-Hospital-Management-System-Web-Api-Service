/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author VATSAL
 */
public class LabReport {
    String pid;
     Double checkin_no,laboratory_no,glucose,hemoglobin,rdc,wbc,afp,psa,cost;
      Date lab_date;
      
      
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
     public Double getRDC() {
       return rdc;
    }
     public Double getWBC() {
       return wbc;
    }
     public Double getAFP() {
       return afp;
    }
     public Double getPSA() {
       return psa;
    }
     public Double getCost() {
       return cost;
    }
     public String getLabDate(){
          if(lab_date==null)
        {
            return "not Specified date";
        }
        else{
            return lab_date.toString();
        }
    }
}
