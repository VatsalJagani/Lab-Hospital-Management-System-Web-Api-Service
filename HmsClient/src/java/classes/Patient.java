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
public class Patient {

    public String pid;
    public String name;
    public String contact_no;
    public String address;
    public String city;
    public boolean marital_status;
    public boolean gender;
    public Date birthdate;
    public Date reg_date;

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getContactNo() {
        return contact_no;
    }

    public boolean getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public boolean getMaritalStatus() {
        return marital_status;
    }

    public Date getRegDate() {
        return reg_date;
    }

    public String toString() {
        return "pid:" + pid + " name:" + name + " contact_no:" + contact_no + " address:" + address + " city:" + city + " marital_status:" + marital_status + " gender:" + gender + " birthdate:" + birthdate + " reg_date:" + reg_date;
    }
}
