package com.eomcs.lms.handler.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.eomcs.lms.handler.Command;

public class BoardDetailCommand implements Command {

  Scanner keyboard;

  public BoardDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    Connection conn = null;
    Statement s = null;
    ResultSet rs = null;
    
    try {
    //DriverManager.registerDriver(new Driver());
    
      conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb"
          , "study", "1111");
      s = conn.createStatement();
      
      rs = s.executeQuery("SELECT bno, cont, cdt, view, mno, lno"
                                  + " FROM board"
                                  + " WHERE bno=" + no);
      if (rs.next()) {
        System.out.printf("번호: %3d\n", rs.getInt("bno"));
        System.out.printf("내용: %3s\n", rs.getString("cont"));
        System.out.printf("작성일: %3s\n", rs.getString("cdt"));
        System.out.printf("조회수: %3d\n", rs.getInt("view"));
        System.out.printf("작성자: %3d\n", rs.getInt("mno"));
        System.out.printf("수업: %3s\n", rs.getInt("lno"));
      } else
        System.out.println("해당 번호의 게시물이 없습니다.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (SQLException e) {e.printStackTrace();}
      try {s.close();} catch (SQLException e) {e.printStackTrace();}
      try {conn.close();} catch (SQLException e) {e.printStackTrace();}
    }
  }
}
