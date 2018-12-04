package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;

public class BoardDao {

  public List<Board> findAll() throws SQLException {
    DriverManager.registerDriver(new Driver());

    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT bno, cont, cdt, view FROM board");
        )
    {
      List<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));

        list.add(board);

      }
      return list;
    } catch (SQLException e) {
      throw e;
    } 
  }
  
  public Board findByNo(int no) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement();
        ResultSet  rs = s.executeQuery("SELECT bno, cont, cdt, view, mno, lno"
            + " FROM board"
            + " WHERE bno=" + no);
        )
    {
      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        board.setWriterNo(rs.getInt("mno"));
        board.setLessonNo(rs.getInt("lno"));
        return board;
      } else {
        return null;
      }
    }
  }
  
  public int insert(Board board) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb"
            , "study", "1111");
        Statement s = conn.createStatement();
        )
    {
      return s.executeUpdate("INSERT INTO board(cont, mno, lno) "
          + "values('"+ board.getContents()
          + "', " + board.getWriterNo()
          + ", " + board.getLessonNo() + ")");
      }
  }
  
  public int update(Board board) throws SQLException {
    
    try (
        Connection conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement();
        )
    {
      return s.executeUpdate("Update board SET cont = '"
          + board.getContents() + "'"
          + " WHERE bno = " + board.getNo());
    }
  }
  
  public int delete(int no) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        Statement s = conn.createStatement())
    {
    return s.executeUpdate("DELETE FROM board WHERE bno = " + no);
    } 
  }
}
