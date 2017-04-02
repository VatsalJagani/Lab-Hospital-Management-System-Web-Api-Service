/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author sahdev
 */
        public class Patient
    {
        public String pid;

        public String name;

        public String contact_no;

        public String address;

        public String city ;

        public boolean marital_status ;

        public boolean gender ;

        public Date birthdate ;

        public Date reg_date ;
        
        public String getPid(){
            return pid;
        }
        
        public String getName(){
            return name;
        }
        
        public String getAddress(){
            return address;
        }
        
        public String getCity(){
            return city;
        }
        
        public String getContactNo(){
            return contact_no;
        }
        
        public boolean getGender(){
            return gender;
        }
        
        public String getBirthdate(){
            if(birthdate==null){
                return "not specified";
            }
            else{
                return birthdate.toString();
            }
        }
        
        public String getRegDate(){
            if(reg_date==null){
                return "not specified";
            }
            else{
                return reg_date.toString();
            }
        }
    }
