package com.eomcs.lms.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  private BoardDao dao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.dao = iocContainer.getBean(BoardDao.class);
  }
  
  @Override
  public void doGet(
      HttpServletRequest request,
      HttpServletResponse response) throws ServletException {
    response.setContentType("text/html;charset=utf-8");
    
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      
      Board board = dao.findByNo(no);
      
      RequestDispatcher rd = request.getRequestDispatcher("/board/detail.jsp");
      
      request.setAttribute("board", board);
      
      rd.include(request, response);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    
  }
}
