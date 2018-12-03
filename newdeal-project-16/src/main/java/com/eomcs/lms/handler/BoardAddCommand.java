package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardAddCommand implements Command {
  
  Scanner keyboard;
  
  public BoardAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    

    Connection conn = null;
    Statement s = null;
    try {
    
      System.out.print("내용? ");
      String content = keyboard.nextLine();
      
      System.out.println("작성자 번호?");
      String writerNo = keyboard.nextLine();
      
      System.out.println("수업 번호?");
      String lessonNo = keyboard.nextLine();
    
      conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb"
          , "study", "1111");
      s = conn.createStatement();
      
      s.executeUpdate("INSERT INTO board(cont, mno, lno) "
          + "values('"+ content 
          + "', " + writerNo
          + ", " + lessonNo + ")");
      
      System.out.println("입력이 완료되었습니다.");
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {s.close();} catch (SQLException e) {e.printStackTrace();}
        try {conn.close();} catch (SQLException e) {e.printStackTrace();}
      }
  }
}
