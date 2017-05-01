/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.BillList;
import classes.EmployeeList;
import classes.LabReportList;
import classes.Patient;
import classes.PlaceList;
import classes.ServiceConnection;
import classes.TreatmentReportList;
import java.io.IOException;
import java.io.PrintWriter;
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
public class GetScheduleDetails extends HttpServlet {

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
        boolean flag=false;
        /* check login here*/
        if(true){
            boolean a=getLists();
            if(a)
                request.getRequestDispatcher("/s/sch.jsp").forward(request, response);
            else{
                request.setAttribute("msg", "Error found...Please try again later!!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("msg", "Error found...Please try again later!!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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

    private boolean getLists() {
        EmployeeList elist=null;
        PlaceList plist=null;
        try {
            String output = ServiceConnection.output("emp");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Output1111:"+output);
            //JSON from String to Object
            elist = mapper.readValue(output, EmployeeList.class);
            req.setAttribute("emp", elist);
            
            String output2 = ServiceConnection.output("places");
            ObjectMapper mapper2 = new ObjectMapper();
            System.out.println("Output2222:"+output2);
            //JSON from String to Object
            plist = mapper.readValue(output2, PlaceList.class);
            req.setAttribute("places",plist);
            
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
