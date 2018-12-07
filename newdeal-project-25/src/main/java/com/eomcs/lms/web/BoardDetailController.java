package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/detail")
public class BoardDetailController implements PageController {

  private BoardDao boardDao;
  
  public BoardDetailController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=utf-8");
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Board board = boardDao.findByNo(no);
    
    request.setAttribute("board", board);
    
    return "/board/detail.jsp";
  }
}
