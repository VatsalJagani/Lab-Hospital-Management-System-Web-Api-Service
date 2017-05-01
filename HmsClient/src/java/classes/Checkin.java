/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *
 * @author VATSAL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Checkin {
    public String pid;
    public Double checkin_no,room,checkin_by;
    public Date in_time,out_time;
            
    public String getPid() {
       return pid;
    }
    public Double getCheckinNo() {
       return checkin_no;
    }
    public Double getRoom() {
       return room;
    }
    public String getIntime(){
        if(in_time==null)
        {
            return "not Specified date";
        }
        else{
            return in_time.toString();
        }
    }
    public String getOuttime(){
          if(out_time==null)
        {
            return "not Specified date";
        }
        else{
            return out_time.toString();
        }
    }
}
