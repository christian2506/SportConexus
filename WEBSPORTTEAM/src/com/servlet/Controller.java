package com.servlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CHRISTIAN on 30/03/2017.
 */
@WebServlet(name = "Controller")
public class Controller extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset =UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String _NomUser=request.getParameter("nom");
            String _password=request.getParameter("password");

            try {
                if (_NomUser!=null)
                {
                    if (_NomUser.equals("juan") && _password.equals("123")  )
                    {

                        response.sendRedirect("welcome.jsp");

                    }
                    else
                    {
                        out.println("Acceso fallido && Trata de nuevo");
                    }
                }

            }
            catch (Exception ex)
            {
                out.println("Error :" +ex.getMessage());
            }

        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
