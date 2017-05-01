using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebService.Models
{
    public class EmployeeList
    {
        public List<Employee> list { get; set; }
        public EmployeeList()
        {
            list = new List<Employee>();
        }
    }
    public class Employee
    {
        public decimal empid { get; set; }
        
        public string emp_type { get; set; }

        public string name { get; set; }

        public Employee(employee e)
        {
            empid = e.empid;
            emp_type = e.emp_type;
            name = e.name;
        }
    }

    public class PlaceList
    {
        public List<Place> list { get; set; }
        public PlaceList()
        {
            list = new List<Place>();
        }
    }
    public class Place
    {
        public decimal place_id { get; set; }

        public string place_type { get; set; }

        public string description { get; set; }

        public System.Nullable<decimal> shift1 { get; set; }

        public System.Nullable<decimal> shift2 { get; set; }

        public System.Nullable<decimal> shift3 { get; set; }

        public Place(place p)
        {
            place_id = p.place_id;
            place_type = p.place_type;
            description = p.description;
            shift1 = p.shift1;
            shift2 = p.shift2;
            shift3 = p.shift3;
        }
    }
}