package com.eomcs.lms.handler.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.eomcs.lms.handler.Command;

public class BoardUpdateCommand implements Command {
  
  Scanner keyboard;
  
  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    
    ResultSet rs = null;
    
    try (Connection conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement();
        ) {
      System.out.print("번호? ");
      int bno = Integer.parseInt(keyboard.nextLine());
      
      rs = s.executeQuery("SELECT cont FROM board WHERE bno = " + bno);
      if(rs.next()) {
        String oldContent = rs.getString("cont");
        System.out.printf("내용(%s)", oldContent);
      }
      
      rs.close();
      
      String content = keyboard.nextLine();
      s.executeUpdate("Update board SET cont = '" + content + "'"
          + " WHERE bno = " + bno);
      
      System.out.println("변경되었습니다.");
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }
  
}
