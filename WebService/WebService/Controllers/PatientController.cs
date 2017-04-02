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
        public CheckinList getPatientCheckInList([FromBody] string patientID)
        {
            CheckinList checkins = new CheckinList();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<checkin> l = d.checkins.Where(i => i.pid == Int32.Parse(patientID));
                    foreach(checkin c in l)
                    {
                        checkins.list.Add(new Checkin(c));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return checkins;
        }

        [Route("api/bills/")]
        public List<Bill> getPatientBills(string patientID, int checkinNo)
        {
            List<Bill> list = new List<Bill>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<bill> l = d.bills.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (bill b in l)
                    {
                        list.Add(new Bill(b));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;
            
        }


        [Route("api/lab_reports/")]
        public List<LabReport> getPatientLaboratoryReports(string patientID, int checkinNo)
        {
            List<LabReport> list = new List<LabReport>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<lab_report> l = d.lab_reports.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (lab_report lr in l)
                    {
                        list.Add(new LabReport(lr));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;

        }

        [Route("api/treatments")]
        public List<TreatmentReport> getPatientTreatmentReports(string patientID, int checkinNo)
        {
            List<TreatmentReport> list = new List<TreatmentReport>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<treatment> l = d.treatments.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (treatment t in l)
                    {
                        list.Add(new TreatmentReport(t));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;

        }

        
        [Route("api/medical_bills/")]
        public List<MedicalBill> getPatientMedicalBills(string patientID, int checkinNo)
        {
            List<MedicalBill> list = new List<MedicalBill>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<medical_bill> l = d.medical_bills.Where(i => i.checkin_no == checkinNo && i.pid == Int32.Parse(patientID));
                    foreach (medical_bill t in l)
                    {
                        list.Add(new MedicalBill(t));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;

        }
    }

}
