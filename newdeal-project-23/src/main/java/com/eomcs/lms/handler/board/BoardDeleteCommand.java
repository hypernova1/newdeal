package com.eomcs.lms.handler.board;

import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.handler.Command;

@Component("/board/delete")
public class BoardDeleteCommand implements Command {
  
  private Scanner keyboard;
  private BoardDao dao;
  
  public BoardDeleteCommand(Scanner keyboard, BoardDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
      
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    try {
      if(dao.delete(no) > 0)
        System.out.println("삭제되었습니다.");
      else
        System.out.println("해당 번호의 게시물이 없습니다.");
      
    } catch (NumberFormatException | SQLException e) {
      e.printStackTrace();
    }
  }
  
}
