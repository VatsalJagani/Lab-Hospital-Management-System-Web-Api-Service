/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author VATSAL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    public double empid;
    public String emp_type,name;
    
    public double getEmpId(){
        return empid;
    }
    public String getEmpType(){
        return emp_type;
    }
    public String getName(){
        return name;
    }
}
