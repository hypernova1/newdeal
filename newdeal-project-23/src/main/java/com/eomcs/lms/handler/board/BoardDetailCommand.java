package com.eomcs.lms.handler.board;

import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.Command;

@Component("/board/detail")
public class BoardDetailCommand implements Command {

  private Scanner keyboard;
  private BoardDao dao;

  public BoardDetailCommand(Scanner keyboard, BoardDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    Board board = null;
    try {
      board = dao.findByNo(no);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    System.out.printf("번호: %3d\n", board.getNo());
    System.out.printf("내용: %3s\n", board.getContents());
    System.out.printf("작성일: %3s\n", board.getCreatedDate());
    System.out.printf("조회수: %3d\n", board.getViewCount());
    System.out.printf("작성자: %3d\n", board.getWriterNo());
    System.out.printf("수업: %3s\n", board.getLessonNo());
  }
}
