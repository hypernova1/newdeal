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
import net.sf.json.JSONArray;

@WebServlet("/comment/list")
public class CommentList extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private CommentDao dao = new CommentDao();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setCharacterEncoding("utf-8");
    HttpSession session = request.getSession();
    
    if (session.getAttribute("loginuser") == null) {
      response.sendRedirect("/demoweb/loginform?returnurl=" + request.getRequestURI());
      return;
    }
    
    int boardNo = Integer.parseInt(request.getParameter("boardno"));
    List<BoardComment> list = dao.getCommentList(boardNo);
    JSONArray obj = JSONArray.fromObject(list);
    
    response.getWriter().print(obj);
    response.getWriter().flush();
    
  }
  
  

}
