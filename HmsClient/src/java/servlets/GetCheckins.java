/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.CheckinList;
import classes.Patient;
import classes.ServiceConnection;
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
public class GetCheckins extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        Patient p=(Patient)session.getAttribute("patient");
        boolean flag=false;
        if(p!=null){
            CheckinList clist=getCheckins(p);
            if(clist!=null){
                request.setAttribute("clist", clist);
                request.getRequestDispatcher("/p/checkin.jsp").forward(request, response);
            }
        }
        if(!flag){
            request.setAttribute("body", "Unexpected error found, try again!!");
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

    private CheckinList getCheckins(Patient p) {
        CheckinList clist=null;
        try {
            String output = ServiceConnection.output("checkins?patientID=" + p.pid);
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("Output:"+output);
            //JSON from String to Object
            clist = mapper.readValue(output, CheckinList.class);

        } catch (Exception e) {

            e.printStackTrace();
        }
        return clist;
    }
}
