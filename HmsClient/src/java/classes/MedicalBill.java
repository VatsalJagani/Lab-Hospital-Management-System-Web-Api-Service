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
 * 
 * Not using right now , but can be useful in future
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalBill {
    String pid,med_description;
     Double checkin_no,med_no,cost;
     Date med_date;
     
      public String getPid() {
       return pid;
    }
     public String getMedDescription() {
       return med_description;
    }
     public Double getCheckinNo() {
       return checkin_no;
    }
     public Double getMedNo() {
       return med_no;
    }
     public Double getCost() {
       return cost;
    }
    
   public Date getMedDate(){
          
            return med_date;
        
    }
}
