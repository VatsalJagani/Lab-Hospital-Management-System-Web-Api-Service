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
public class Bill {
    String pid;
     Double checkin_no,bill_no,doctor_fee,room_fee,lab_fee,medical_fee,op_fee,other_fee;
     Date bill_date;

     
     public String getPid() {
       return pid;
    }
     public Double getCheckinNo() {
       return checkin_no;
    }
     public Double getBillNo() {
       return bill_no;
    }
     public Double getDoctorFee() {
       return doctor_fee;
    }
     public Double getRoomFee() {
       return room_fee;
    }
     public Double getLabFee() {
       return lab_fee;
    }
     public Double getMedicalFee() {
       return medical_fee;
    }
     public Double getOpFee() {
       return op_fee;
    }
     public Double getOtherFee() {
       return other_fee;
    }
     public String getBillDate(){
          if(bill_date==null)
        {
            return "not Specified date";
        }
        else{
            return bill_date.toString();
        }
    }
}
