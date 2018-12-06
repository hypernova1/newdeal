package com.eomcs.lms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private BoardDao dao;
  
  @Override
  public void init() throws ServletException {
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer =
        (ApplicationContext) sc.getAttribute("iocContainer");
    
    this.dao = iocContainer.getBean(BoardDao.class);
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      request.setAttribute("count", dao.delete(no));
      
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/board/delete.jsp").include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
