package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Controller
public class BoardUpdateController  {
  
  private BoardDao boardDao;
  
  public BoardUpdateController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping("/board/update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    Board board = new Board();
    int no = Integer.parseInt(request.getParameter("no"));
    board.setNo(no);
    board.setContents(request.getParameter("contents"));
    boardDao.update(board);
    
    return "redirect:./detail?no=" + no;
      
  } 
  
}
