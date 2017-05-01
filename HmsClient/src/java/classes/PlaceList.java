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
public class PlaceList {
    List<Place> placeList;
    
    public List<Place> getList(){
        return placeList;
    }
    public void setList(List<Place> list){
        this.placeList=list;
    }
}
