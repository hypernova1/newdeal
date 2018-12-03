package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteCommand implements Command {
  
  Scanner keyboard;
  
  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    
    try (Connection conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement();
        ) {
      System.out.print("번호? ");
      int bno = Integer.parseInt(keyboard.nextLine());
      
      s.executeUpdate("DELETE FROM board WHERE bno = " + bno);
      
      System.out.println("삭제되었습니다.");
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }
  
}
