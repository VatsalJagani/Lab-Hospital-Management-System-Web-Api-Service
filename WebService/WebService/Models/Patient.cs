using System;
using System.Collections.Generic;
using System.Data.Linq;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace WebService.Models
{
    public class CheckinList
    {
        public List<Checkin> list {get; set;}
        public CheckinList()
        {
            list=new List<Checkin>(); 
        }
    }
    public class Checkin
    {
        public String pid { get; set; }

        public decimal checkin_no { get; set; }

        public decimal checkin_by { get; set; }

        public System.Nullable<decimal> room { get; set; }

        public System.Nullable<System.DateTime> in_time { get; set; }

        public System.Nullable<System.DateTime> out_time { get; set; }


        public Checkin(checkin c)
        {
            checkin_by = c.checkin_by;
            pid = c.pid.ToString();
            checkin_no = c.checkin_no;
            room = c.room;
            in_time = c.in_time;
            out_time = c.out_time;
        }
    }

    public class Patient
    {
        public String pid { get; set; }

        public string name { get; set; }

        public string contact_no { get; set; }

        public string address { get; set; }

        public string city { get; set; }

        public bool marital_status { get; set; }

        public bool gender { get; set; }

        public System.Nullable<System.DateTime> birthdate { get; set; }

        
        public System.Nullable<System.DateTime> reg_date { get; set; }
        

        public Patient(patient p)
        {
            address = p.address;
            birthdate=p.birthdate;
            city=p.city;
            contact_no=p.contact_no;
            gender=p.gender;
            marital_status=p.marital_status;
            name=p.name;
            pid=p.pid.ToString();
            reg_date=p.reg_date;
        }
    }

    public class BillList
    {
        public List<Bill> list { get; set; }
        public BillList()
        {
            list = new List<Bill>();
        }
    }
    public class Bill
    {
        public String pid { get; set; }

        public decimal checkin_no { get; set; }

        public decimal bill_no { get; set; }


        public System.Nullable<System.DateTime> bill_date { get; set; }

        public decimal doctor_fee { get; set; }

        public decimal room_fee { get; set; }

        public decimal lab_fee { get; set; }

        public decimal medical_fee { get; set; }

        public decimal op_fee { get; set; }

        public decimal other_fee { get; set; }

        public Bill(bill b)
        {
          bill_date  =b.bill_date;
           bill_no= b.bill_no;
           checkin_no= b.checkin_no;
           doctor_fee= b.doctor_fee;
           lab_fee= b.lab_fee;
           medical_fee= b.medical_fee;
           op_fee= b.op_fee;
           other_fee= b.other_fee;
            pid=b.pid.ToString();
            room_fee=b.room_fee;
        }
    }

    public class TreatmentReportList
    {
        public List<TreatmentReport> list { get; set; }
        public TreatmentReportList()
        {
            list = new List<TreatmentReport>();
        }
    }
    public class TreatmentReport
    {
        public String pid { get; set; }

        public decimal checkin_no { get; set; }

        public decimal tr_no { get; set; }

        public System.Nullable<System.DateTime> tr_date { get; set; }

        
        public string medical_pre { get; set; }

        public string lab_pre { get; set; }

        public string suggestion { get; set; }

        public TreatmentReport(treatment t)
        {
            pid = t.pid.ToString();
            checkin_no = t.checkin_no;
            tr_no = t.tr_no;
            tr_date = t.tr_date;
            medical_pre = t.medical_pre;
            lab_pre = t.lab_pre;
            suggestion = t.suggestion;
        }
    }

    public class LabReportList
    {
        public List<LabReport> list { get; set; }
        public LabReportList()
        {
            list = new List<LabReport>();
        }
    }
    public class LabReport
    {
        public String pid { get; set; }

        public decimal checkin_no { get; set; }

        public decimal laboratory_no { get; set; }

        public System.Nullable<decimal> glucose { get; set; }

        public System.Nullable<decimal> hemoglobin { get; set; }

        public System.Nullable<decimal> rdc { get; set; }

        public System.Nullable<decimal> wbc { get; set; }

        public System.Nullable<decimal> afp { get; set; }

        public System.Nullable<decimal> hcg { get; set; }

        public System.Nullable<decimal> psa { get; set; }

        public string lab_description { get; set; }

        public decimal cost { get; set; }

        public System.Nullable<System.DateTime> lab_date { get; set; }
        
        public LabReport(lab_report l)
        {
            pid = l.pid.ToString();
            checkin_no = l.checkin_no;
            laboratory_no = l.laboratory_no;
            glucose = l.glucose;
            hemoglobin = l.hemoglobin;
            rdc = l.rdc;
            wbc = l.wbc;
            afp = l.afp;
            hcg = l.hcg;
            psa = l.psa;
            lab_description = l.lab_description;
            lab_date = l.lab_date;
            cost = l.cost;
        }
    }

    public class MedicalBillList
    {
        public List<MedicalBill> list { get; set; }
        public MedicalBillList()
        {
            list = new List<MedicalBill>();
        }
    }
    public class MedicalBill
    {
        public String pid { get; set; }

        public decimal checkin_no { get; set; }

        public decimal med_no { get; set; }

      
        public System.Nullable<System.DateTime> med_date { get; set; }

        public string med_description { get; set; }

        public decimal cost { get; set; }

        public MedicalBill(medical_bill b)
        {
            pid = b.pid.ToString();
            checkin_no = b.checkin_no;
            med_no = b.med_no;
            med_description = b.med_description;
            med_date = b.med_date;
            cost = b.cost;
        }
    }
}