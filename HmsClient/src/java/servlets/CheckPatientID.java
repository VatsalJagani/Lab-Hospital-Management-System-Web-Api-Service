/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Patient;
import classes.ServiceConnection;
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
public class CheckPatientID extends HttpServlet {

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
        HttpSession session=request.getSession();
        
        CaptchasDotNet captchas = new CaptchasDotNet(
                request.getSession(true), // Ensure session
                "demo", // client
                "secret" // secret
        );
// Read the form values
        String patientID = request.getParameter("patientID");
        String captcha = request.getParameter("captcha");

        Patient p = null;
// Check captcha
        String body = null;
        switch (captchas.check(captcha)) {
            case 's':
                body = "Session seems to be timed out or broken. ";
                body += "Please try again or report error to administrator.";
                break;
            case 'm':
                body = "Every CAPTCHA can only be used once. ";
                body += "The current CAPTCHA has already been used. ";
                body += "Please use back button and reload";
                break;
            case 'w':
                body = "You entered the wrong captcha.. ";
                body += "Please use back button and try again. ";
                break;
            default:
                p = getPatientDetails(patientID);
                if (p == null) {
                    body = "Patient not found...";
                } else {
                    session.setAttribute("patient", p);
                    request.getRequestDispatcher("/p/patient_info.jsp").forward(request, response);
                }
                break;
        }
        if (p == null) {
            request.setAttribute("msg", body);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

    private Patient getPatientDetails(String patientID) {
        /* store patient object in session */
        Patient p = null;
        try {
            String output = ServiceConnection.output("patient?patientID=" + patientID);
            ObjectMapper mapper = new ObjectMapper();

            //JSON from String to Object
            p = mapper.readValue(output, Patient.class);

            /*
             System.out.println(user.address);
             System.out.println(user.birthdate);
             System.out.println(user.city);
             System.out.println(user.city);
             System.out.println(user.contact_no);
             System.out.println(user.gender);
             System.out.println(user.marital_status);
             System.out.println(user.name);
             System.out.println(user.pid);
             System.out.println(user.reg_date);
             */
        } catch (Exception e) {

            e.printStackTrace();
        }
        return p;
    }
}
