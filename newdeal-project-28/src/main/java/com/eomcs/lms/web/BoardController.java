package com.eomcs.lms.web;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  private BoardDao boardDao;
  private LessonDao lessonDao;
  
  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }

  @RequestMapping("add")
  public String add(Board board, HttpSession session) throws SQLException {
    
    Member loginUser = (Member) session.getAttribute("loginUser");
    
    board.setWriterNo(loginUser.getNo());

    boardDao.insert(board);
    
    return "redirect:./list";
  }
  
  @RequestMapping("delete")
  public void delete(Integer no, Model model) throws SQLException {
    model.addAttribute("count", boardDao.delete(no));
  }
  
  @RequestMapping("form")
  public void form(Model model, HttpSession session)
      throws Exception {
    
    Member loginUser = (Member) session.getAttribute("loginUser");
    List<Map<String, Object>> lessons = lessonDao.findByParticipantNo(loginUser.getNo());
    
    model.addAttribute("lessons", lessons);
  }
  
  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {
    
    Board board = boardDao.findByNo(no);
    
    model.addAttribute("board", board);
  }
  
  @RequestMapping("list")
  public void list(Model model) throws Exception {
    
    List<Board> list = boardDao.findAll();
    model.addAttribute("list", list);
  }
  
  @RequestMapping("update")
  public String update(Board board) throws Exception {
    boardDao.update(board);
    
    return "redirect:./detail?no=" + board.getNo();
  } 
  
}
