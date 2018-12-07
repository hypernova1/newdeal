package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Component("/board/update")
public class BoardUpdateController implements PageController {
  
  private BoardDao boardDao;
  
  public BoardUpdateController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    Board board = new Board();
    int no = Integer.parseInt(request.getParameter("no"));
    board.setNo(no);
    board.setContents(request.getParameter("contents"));
    boardDao.update(board);
    
    return "redirect:./detail?no=" + no;
      
  } 
  
}
