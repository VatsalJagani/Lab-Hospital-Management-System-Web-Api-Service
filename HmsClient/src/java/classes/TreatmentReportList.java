/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author VATSAL
 */
public class TreatmentReportList {
    List<TreatmentReport> treatmentReportList;
    
    public List<TreatmentReport> getList(){
        return treatmentReportList;
    }
    public void setList(List<TreatmentReport> list){
        this.treatmentReportList=list;
    }
}
