package com.demoweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demoweb.model.dao.CommentDao;
import com.demoweb.model.dto.BoardComment;
import com.demoweb.model.dto.Member;
import net.sf.json.JSONArray;

@WebServlet("/comment/insert")
public class CommentInsert extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private CommentDao dao = new CommentDao();
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setCharacterEncoding("utf-8");
    HttpSession session = request.getSession();
    
    if (session.getAttribute("loginuser") == null) {
      response.sendRedirect("/demoweb/loginform?returnurl=" + request.getRequestURI());
      return;
    }
    Member member = (Member) session.getAttribute("loginuser");
    BoardComment comment = new BoardComment();
    int boardNo = Integer.parseInt(request.getParameter("boardno"));
    comment.setBoardNo(boardNo);
    comment.setContent(request.getParameter("content"));
    comment.setWriter(member.getMemberId());
    dao.insert(comment);
    
    JSONArray obj = JSONArray.fromObject(dao.getCommentList(boardNo));
    response.getWriter().print(obj);
    response.getWriter().flush();
    
    
    
    
  }
  
  

}
