package com.eomcs.lms.handler.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.eomcs.lms.handler.Command;

public class LessonListCommand implements Command {

  Scanner keyboard = new Scanner(System.in);

  public LessonListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {

    ResultSet rs = null;
    try (Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement()) {
      
      rs = s.executeQuery("SELECT lno, title, sdt, edt tot_hr FROM lesson");
      
      while(rs.next()){
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4s\n", rs.getInt("lno")
            , rs.getString("title"), rs.getString("sdt"), rs.getString("edt")
            , rs.getString("tot_hr"));
      }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
      try {rs.close();} catch (SQLException e) {e.printStackTrace();}
    }
  }

}
