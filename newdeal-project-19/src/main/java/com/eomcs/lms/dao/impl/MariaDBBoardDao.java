package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {

  public List<Board> findAll() throws SQLException {
    DriverManager.registerDriver(new Driver());

    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        PreparedStatement s = conn.prepareStatement(
            "SELECT bno, cont, cdt, view FROM board");
        ResultSet rs = s.executeQuery();
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
        PreparedStatement s = conn.prepareStatement(
            "SELECT bno, cont, cdt, view, mno, lno"
            + " FROM board"
            + " WHERE bno=?");
        )
    {
      Board board = new Board();
      s.setInt(1, no);
      
      try(ResultSet  rs = s.executeQuery()){
        if (rs.next()) {
          board.setNo(rs.getInt("bno"));
          board.setContents(rs.getString("cont"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("view"));
          board.setWriterNo(rs.getInt("mno"));
          board.setLessonNo(rs.getInt("lno"));
        } else {
          return null;
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return board;
    }
  }
  
  public int insert(Board board) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        PreparedStatement s = conn.prepareStatement(
            "INSERT INTO board(cont, mno, lno) values(?, ?, ?)")
        )
    {
      s.setString(1, board.getContents());
      s.setInt(2, board.getWriterNo());
      s.setInt(3, board.getLessonNo());
      return s.executeUpdate();
    }
  }
  
  public int update(Board board) throws SQLException {
    
    try (
        Connection conn = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        PreparedStatement s = conn.prepareStatement(
          "Update board SET cont=? WHERE bno=?");
        )
    {
      s.setString(1, board.getContents());
      s.setInt(2, board.getWriterNo());
      
      return s.executeUpdate();
    }
  }
  
  public int delete(int no) throws SQLException {
    try (
        Connection conn = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        PreparedStatement s = conn.prepareStatement(
            "DELETE FROM board WHERE bno=?"))
    {
    return s.executeUpdate();
    } 
  }
}
