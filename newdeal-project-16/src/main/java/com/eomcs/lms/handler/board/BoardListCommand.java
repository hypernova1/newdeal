package com.eomcs.lms.handler.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.handler.Command;

public class BoardListCommand implements Command {
  
  Scanner keyboard;
  
  public BoardListCommand(Scanner keyboard) {
    super();
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection conn = null;
    Statement s = null;
    ResultSet rs = null;
    
    try {
    //MariaDB JDBC 드라이버(java.sql.Driver) 구현체 로딩
    DriverManager.registerDriver(new Driver());
    
    //DBMS에 연결
    conn = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3307/studydb"
        , "study", "1111");
    //SQL 전송을 담당할 객체 준비
    s = conn.createStatement();
    
    //SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
    rs = s.executeQuery("SELECT bno, cont, cdt, view "
                                + "FROM board");
    //DBMS에서 한 개의 레코드를 가져온다.
    while (rs.next()) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          rs.getInt("bno")
          , rs.getString("cont")
          , rs.getDate("cdt")
          , rs.getInt("view"));
    }
    }catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (SQLException e) {e.printStackTrace();}
      try {s.close();} catch (SQLException e) {e.printStackTrace();}
      try {conn.close();} catch (SQLException e) {e.printStackTrace();}
    }
    
  }
}
