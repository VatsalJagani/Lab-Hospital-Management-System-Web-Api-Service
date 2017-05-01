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
public class BillList {
    List<Bill> billList;
    
    public List<Bill> getList(){
        return billList;
    }
    public void setList(List<Bill> list){
        this.billList=list;
    }
}
