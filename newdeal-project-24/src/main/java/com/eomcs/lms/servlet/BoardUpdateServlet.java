package com.eomcs.lms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet{
  
  private static final long serialVersionUID = 1L;
  
  private BoardDao dao;
  
  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.dao = iocContainer.getBean(BoardDao.class);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    try {
      Board board = new Board();
      int no = Integer.parseInt(request.getParameter("no"));
      board.setNo(no);
      board.setContents(request.getParameter("contents"));
      dao.update(board);
      
      response.sendRedirect("./detail?no=" + no);
      
    } catch(SQLException e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  } 
  
}
