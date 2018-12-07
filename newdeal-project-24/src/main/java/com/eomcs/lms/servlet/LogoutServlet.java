package com.eomcs.lms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    
    try {
      request.getSession().invalidate();
      response.sendRedirect("./login");
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    
    
  }
}
