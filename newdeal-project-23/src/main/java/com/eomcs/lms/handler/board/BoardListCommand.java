package com.eomcs.lms.handler.board;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.Command;

@Component("/board/list")
public class BoardListCommand implements Command {
  
  Scanner keyboard;
  BoardDao dao;
  
  public BoardListCommand(Scanner keyboard, BoardDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
    try {
      List<Board> list = dao.findAll();
      
      for(Board board : list) {
        System.out.printf("%3d, %-20s, %s, %d\n"
            , board.getNo()
            , board.getContents()
            , board.getCreatedDate()
            , board.getViewCount());
      }
    }catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
