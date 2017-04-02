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
public class TreatmentReport {
    String pid,medical_pre,lab_pre,suggestion;
     Double checkin_no,tr_no;
     Date tr_date;

     
     public String getPid() {
       return pid;
    }
     public String getMedicalPre() {
       return medical_pre;
    }
     public String getLabPre() {
       return lab_pre;
    }
     public String getSuggestion() {
       return suggestion;
    }
     public Double getCheckinNo() {
       return checkin_no;
    }
     public Double getTrNo() {
       return tr_no;
    }
      public String getTrDate(){
          if(tr_date==null)
        {
            return "not Specified date";
        }
        else{
            return tr_date.toString();
        }
    }
}
