package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.web.PageController;

@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  private ApplicationContext iocContainer;
  
  @Override
  public void init() throws ServletException {
     iocContainer = (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
  }
  
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // 클라이언트가 요청한 명령 추출
    // => /app/board/list ---> /board/list
    String controllerPath = request.getPathInfo();

    try {
      // 클라이언트가 요청한 명령을 처리할 객체를 Spring IoC Container에서 찾는다.
      PageController PageController = (PageController) iocContainer.getBean(controllerPath);
      
      String viewUrl = PageController.execute(request, response);
      
      if(viewUrl.startsWith("redirect:"))
        response.sendRedirect(viewUrl.replace("redirect:", ""));
      else
        request.getRequestDispatcher(viewUrl).include(request, response);
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
