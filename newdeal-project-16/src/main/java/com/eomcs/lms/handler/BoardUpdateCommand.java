package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  List<Board> list;
  
  public BoardUpdateCommand(Scanner keyboard, List<Board> list) {
    this.keyboard = keyboard;
    this.list = list;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    
    try {
      // 기존 값 복제
      
    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
  
}
