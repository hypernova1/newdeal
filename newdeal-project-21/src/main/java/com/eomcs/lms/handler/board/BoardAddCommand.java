package com.eomcs.lms.handler.board;

import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.Command;

@Component("/board/add")
public class BoardAddCommand implements Command {
  
  private Scanner keyboard;
  private BoardDao dao;
  
  public BoardAddCommand(Scanner keyboard, BoardDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
    Board board = new Board();
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    System.out.println("작성자 번호?");
    board.setWriterNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.println("수업 번호?");
    board.setLessonNo(Integer.parseInt(keyboard.nextLine()));
    
    
    try {
      dao.insert(board);
      System.out.println("입력이 완료되었습니다.");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}
