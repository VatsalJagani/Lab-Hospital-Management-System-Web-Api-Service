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
public class LabReportList {
    List<LabReport> labReportList;
    
    public List<LabReport> getList(){
        return labReportList;
    }
    public void setList(List<LabReport> list){
        this.labReportList=list;
    }
}
