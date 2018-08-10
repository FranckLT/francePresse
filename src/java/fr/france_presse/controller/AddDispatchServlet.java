/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.france_presse.controller;

import fr.france_presse.dispatch_service.DispatchServiceDB;
import fr.france_presse.dispatch_service.DispatchServiceInterface;
import fr.france_presse.java_bean.Dispatch;
import fr.france_presse.java_bean.Reporter;
import fr.france_presse.utils.Method;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class AddDispatchServlet extends HttpServlet {

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
         HttpSession session = request.getSession();
        
        if (session.getAttribute("user")==null) {
            
            response.sendRedirect("/FrancePresse/login");
            
        } else {
        
        getServletContext().getRequestDispatcher("/Jsp/addDispatch.jsp").forward(request, response);
        
        }
       
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
        
        String titleParameterValue = request.getParameter("title");
        
        String reporterParameterValue = request.getParameter("reporter");
        
        Dispatch dispatch = new Dispatch();
        
        dispatch.setTitle(titleParameterValue);
        
        dispatch.setPublishTime(LocalDateTime.now());
        
        dispatch.setReporterName(reporterParameterValue);
       
        DispatchServiceInterface dsi = new DispatchServiceDB();
        
        dsi.addDispatch(dispatch);
        
        response.sendRedirect("/FrancePresse/");
        
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

}
