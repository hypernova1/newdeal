package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private MemberDao dao;

  @Override
  public void init() throws ServletException {
    ApplicationContext ac =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.dao = ac.getBean(MemberDao.class);
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/auth/form.jsp").forward(request, response);
  }
  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    
    try {
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      Member member = dao.findByEmailPassword(email, password);

      HttpSession session = request.getSession();
      if(member != null) {
        session.setAttribute("loginUser", member);
        response.sendRedirect("/board/list");
      } else {
        session.invalidate();
        response.sendRedirect("./login");
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    
    
  }
}
