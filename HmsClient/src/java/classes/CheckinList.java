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
public class CheckinList {
    List<Checkin> list;
    
    public List<Checkin> getList(){
        return list;
    }
    public void setList(List<Checkin> list){
        this.list=list;
    }
}
