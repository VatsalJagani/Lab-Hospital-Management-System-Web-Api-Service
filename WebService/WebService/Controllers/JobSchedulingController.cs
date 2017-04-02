using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebService.Models;

namespace WebService.Controllers
{
    public class JobSchedulingController : ApiController
    {

        public List<Employee> getEmployeeList()
        {
            List<Employee> list = new List<Employee>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<employee> l = d.employees.AsQueryable();
                    foreach (employee e in l)
                    {
                        list.Add(new Employee(e));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;
        }

        public List<Place> getPlaceList()
        {
            List<Place> list = new List<Place>();
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    IQueryable<place> l = d.places.AsQueryable();
                    foreach (place p in l)
                    {
                        list.Add(new Place(p));
                    }
                }
                catch (Exception ex)
                {
                    // for error message
                }
            }
            return list;
        }

        public bool scheduleDuty(int placeId, int shift, int empId)
        {
            using (hmsDataContext d = new hmsDataContext())
            {
                try
                {
                    place p = d.places.First(i => i.place_id == placeId);
                    switch (shift)
                    {
                        case 1:
                            {
                                p.shift1 = empId;
                                break;
                            }
                        case 2:
                            {
                                p.shift2 = empId;
                                break;
                            }
                        case 3:
                            {
                                p.shift3 = empId;
                                break;
                            }
                        default:
                            {
                                throw new Exception();
                            }
                    }
                    d.SubmitChanges();
                    return true;
                }
                catch (Exception ex)
                {
                    return false;
                    /* normally because of error in foreign key contraint empID 
                    or 
                    placeID not found */
                }
            }
        }
    }
}
