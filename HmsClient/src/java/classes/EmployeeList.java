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
public class EmployeeList {
    List<Employee> empList;
    
    public List<Employee> getList(){
        return empList;
    }
    public void setList(List<Employee> list){
        this.empList=list;
    }
}
