package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 서블릿을 만들면 톰캣 서버에 알려야 함
// => 서블릿에 url을 부여 (url은 항상 /로 시작)
// => 서블릿을 추가하면 톰캣을 재시작해야 사용 가능
// => 톰캣 서버에 서블릿을 추가한 후 서블릿을 변경한다면 일정 시간이 지난 후에 자동으로 해당 서블릿을 리로딩
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private BoardDao boardDao;
  private ApplicationContext iocContainer;
  
  // 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 바로 호출
  // => init(ServletConfig)가 먼저 호출되고,
  //    init(ServletConfig)가 이 init 메서드를 호출한다.
  @Override
  public void init() throws ServletException {
    
    // BoardDao 객체를 꺼내기 위해 먼저 IoC 컨테이너를 꺼냄
    // 웹 애플리케이션에서 서블릿컨텍스트는 단 하나임
    ServletContext sc = this.getServletContext();
    iocContainer = (ApplicationContext) sc.getAttribute("iocContainer");
    
    try {
      boardDao = iocContainer.getBean(BoardDao.class);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    
    // MIME Type(Multi-purpose Mail Exention
    
    
    try {
      List<Board> list = boardDao.findAll();
      // 게시물 목록을 리퀘스트 객체에 담음
      req.setAttribute("list", list);
      
      // jsp로 실행 위임
      RequestDispatcher rd = req.getRequestDispatcher("/board/list.jsp");
      
      // 촐력 콘텐트 타입을 include하는 쪽에서 규정해야 함
      res.setContentType("text/html;charset=utf-8");
      rd.include(req, res);
      
    }catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    } 
    
  }

}
