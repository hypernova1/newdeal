package com.demoweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demoweb.model.dao.CommentDao;
import net.sf.json.JSONArray;

@WebServlet("/comment/delete")
public class CommentDelete extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private CommentDao dao = new CommentDao();

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    response.setCharacterEncoding("utf-8");
    HttpSession session = request.getSession();
    
    if (session.getAttribute("loginuser") == null) {
      response.sendRedirect("/demoweb/loginform?returnurl=" + request.getRequestURI());
      return;
    }
    
    int commentNo = Integer.parseInt(request.getParameter("commentno"));
    int boardNo = Integer.parseInt(request.getParameter("boardno"));

    dao.deleteComment(commentNo);
    
    JSONArray obj = JSONArray.fromObject(dao.getCommentList(boardNo));
    response.getWriter().print(obj);
    response.getWriter().flush();
  }
}
