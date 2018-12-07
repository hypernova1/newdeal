package com.eomcs.lms.web;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteController implements PageController {
  
  private BoardDao boardDao;
  
  public BoardDeleteController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    
    int no = Integer.parseInt(request.getParameter("no"));
    request.setAttribute("count", boardDao.delete(no));
    
    response.setContentType("text/html;charset=UTF-8");
    
    return "/board/delete.jsp";
    
  }
  
}
