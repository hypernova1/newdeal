package com.demoweb.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demoweb.model.dao.CommentDao;
import com.demoweb.model.dto.BoardComment;

@WebServlet("/comment/list")
public class CommentList extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private CommentDao dao = new CommentDao();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute("loginuser") == null) {
      response.sendRedirect("/demoweb/loginform?returnurl=" + request.getRequestURI());
      return;
    }
    List<BoardComment> list = dao.getCommentList(Integer.parseInt(request.getParameter("boardno")));
    response.setContentType("application/json");
    System.out.println(list.get(0).getContent());

    
  }
  
  

}
