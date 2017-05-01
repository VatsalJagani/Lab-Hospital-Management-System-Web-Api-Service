using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebService.Models;

namespace WebService.Controllers
{
    public class PatientController : ApiController
    {
        [Route("api/patient/")]
        public Patient getPatientDetails([FromUri]string patientID)
        {
            using (hmsDataContext d = new hmsDataContext())
            {
                patient p = null;
                try
                {
                    p = d.patients.First(i => i.pid == Int32.Parse(patientID));
                    return new Patient(p);
                }
                catch (Exception ex)
                {
                    return null;
                }
            }
        }

        
        [Route("api/checkins/")]
        public CheckinList getPatientCheckInList([FromUri] string patientID)
        {
            CheckinList checkins = new CheckinList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    //System.IO.StreamWriter file = new System.IO.StreamWriter("d:\\test.txt", true);
                    
                    IQueryable<checkin> l = d.checkins.Where(i => i.pid == Int32.Parse(patientID));
                    foreach(checkin c in l)
                    {
                        checkins.list.Add(new Checkin(c));
                        //file.WriteLine(c.checkin_no+"  "+c.pid+"\n");
                    }
                    //file.Close();
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return checkins;
        }

        [Route("api/bills/")]
        public BillList getPatientBills(string patientID, int checkinNo)
        {
            BillList bills = new BillList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<bill> l = d.bills.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (bill b in l)
                    {
                        bills.list.Add(new Bill(b));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return bills;
            
        }


        [Route("api/lab_reports/")]
        public LabReportList getPatientLaboratoryReports(string patientID, int checkinNo)
        {
            LabReportList lab_reports = new LabReportList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<lab_report> l = d.lab_reports.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (lab_report lr in l)
                    {
                        lab_reports.list.Add(new LabReport(lr));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return lab_reports;

        }

        [Route("api/treatments")]
        public TreatmentReportList getPatientTreatmentReports(string patientID, int checkinNo)
        {
            TreatmentReportList treatments = new TreatmentReportList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<treatment> l = d.treatments.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (treatment t in l)
                    {
                        treatments.list.Add(new TreatmentReport(t));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return treatments;

        }

        
        [Route("api/medical_bills/")]
        public MedicalBillList getPatientMedicalBills(string patientID, int checkinNo)
        {
            MedicalBillList medical_bills = new MedicalBillList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<medical_bill> l = d.medical_bills.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (medical_bill t in l)
                    {
                        medical_bills.list.Add(new MedicalBill(t));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return medical_bills;

        }
    }

}
