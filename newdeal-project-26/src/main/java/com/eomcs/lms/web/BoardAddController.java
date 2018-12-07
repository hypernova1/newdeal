package com.eomcs.lms.web;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
public class BoardAddController {
  
  private BoardDao boardDao;
  
  public BoardAddController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
  }

  @RequestMapping("/board/add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    Board board = new Board();
    
    board.setContents(request.getParameter("contents"));
    board.setWriterNo(loginUser.getNo());
    board.setLessonNo(Integer.parseInt(request.getParameter("lessonNo")));
    boardDao.insert(board);
    
    return "redirect:./list";
    
  }
}
