/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.BillList;
import classes.LabReportList;
import classes.Patient;
import classes.ServiceConnection;
import classes.TreatmentReportList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author VATSAL
 */
public class GetReports extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpServletRequest req;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        req=request;
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        Patient p=(Patient)session.getAttribute("patient");
        boolean flag=false;
        double check=-55;
        try{
            check=Double.parseDouble(request.getParameter("check_no"));
        }
        catch(Exception e){
            
        }
        if(p!=null && check!=-55){
            boolean a=getReports(p,(int)check);
            if(a)
                request.getRequestDispatcher("/p/reports.jsp").forward(request, response);
            else{
                request.setAttribute("msg", "Error found...Please try again later!!");
                request.getRequestDispatcher("/p/patient_info.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("msg", "Error found...Please try again later!!");
            request.getRequestDispatcher("/p/patient_info.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean getReports(Patient p,int checkinno) {
        BillList blist=null;
        LabReportList llist=null;
        TreatmentReportList trlist=null;
        try {
            String output = ServiceConnection.output("bills?patientID=" + p.pid+"&checkinNo="+checkinno);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Output1111:"+output);
            //JSON from String to Object
            blist = mapper.readValue(output, BillList.class);
            req.setAttribute("bills", blist);
            
            String output2 = ServiceConnection.output("lab_reports?patientID=" + p.pid+"&checkinNo="+checkinno);
            ObjectMapper mapper2 = new ObjectMapper();
            System.out.println("Output2222:"+output2);
            //JSON from String to Object
            llist = mapper.readValue(output2, LabReportList.class);
            req.setAttribute("lab_reports",llist);
            
            String output3 = ServiceConnection.output("treatments?patientID=" + p.pid+"&checkinNo="+checkinno);
            ObjectMapper mapper3 = new ObjectMapper();
            System.out.println("Output3333:"+output3);
            //JSON from String to Object
            trlist = mapper.readValue(output3, TreatmentReportList.class);
            req.setAttribute("treatments", trlist);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
