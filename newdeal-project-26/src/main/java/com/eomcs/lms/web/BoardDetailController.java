package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@Controller
public class BoardDetailController {

  private BoardDao boardDao;
  
  public BoardDetailController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  
  @RequestMapping("/board/detail")
  public String detail(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=utf-8");
    
    int no = Integer.parseInt(request.getParameter("no"));
    
    Board board = boardDao.findByNo(no);
    
    request.setAttribute("board", board);
    
    return "/board/detail.jsp";
  }
}
