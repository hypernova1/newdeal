package com.eomcs.lms.handler.board;

import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.Command;

@Component("/board/update")
public class BoardUpdateCommand implements Command {
  
  private Scanner keyboard;
  private BoardDao dao;
  
  public BoardUpdateCommand(Scanner keyboard, BoardDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
    
    try {
      System.out.print("번호? ");
      int bno = Integer.parseInt(keyboard.nextLine());
      Board board = dao.findByNo(bno);
      
      System.out.println("변경할 내용?(" + board.getContents() + ")");
      board.setContents(keyboard.nextLine());
      
      dao.update(board);
      
      System.out.println("변경되었습니다.");
    } catch(SQLException e) {
      e.printStackTrace();
    }
  } 
  
}
