package com.demoweb.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import com.demoweb.model.dto.BoardComment;

public class CommentDao {
  Connection conn = null;
  PreparedStatement pstmt = null;


  public void insert(BoardComment comment) {
    try {
      conn = ConnectionHelper.getConnection("oracle");
      String sql = "INSERT INTO boardcomment (COMMENTNO, BOARDNO, WRITER, CONTENT)"
          + " VALUES (comment_seq.nextVal, ?, ?, ?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, comment.getBoardNo());
      pstmt.setString(2, comment.getWriter());
      pstmt.setString(3, comment.getContent());
      // 4. 명령 실행
      pstmt.executeUpdate();
      // 5. 결과 있으면 결과 처리

    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      // 6. 연결닫기
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception ex) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception ex) {
        }
    }
  }
  
  public ArrayList<BoardComment> getCommentList(int boardNo) {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;// 조회 결과에 접근하는 참조 변수
    // 데이터베이스의 데이터를 읽어서 저장할 객체 컬렉션
    ArrayList<BoardComment> comments = new ArrayList<>();

    try {
      conn = ConnectionHelper.getConnection("oracle");
      String sql = "SELECT * from boardcomment where boardno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, boardNo);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardComment comment = new BoardComment();
        comment.setCommentNo(rs.getInt(1));
        comment.setBoardNo(boardNo);
        comment.setWriter(rs.getString(3));
        comment.setContent(rs.getString(4));
        comment.setRegDate(rs.getDate(5).toString());

        comments.add(comment);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      // 6. 연결닫기
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception ex) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception ex) {
        }
    }

    return comments;
  }
  
  public int deleteComment(int number) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int count = 0;
    try {
      conn = ConnectionHelper.getConnection("oracle");
      String sql = "delete from boardcomment where commentno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, number);
      count = pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (pstmt != null)
          pstmt.close();
      } catch (Exception ex) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (Exception ex) {
      }
    }
    return count;
  }
  
  public int updateBoard(BoardComment comment) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    int count = 0;
    try {
      conn = ConnectionHelper.getConnection("oracle");
      String sql = "UPDATE boardcomment SET content = ? WHERE commentno = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, comment.getContent());
      pstmt.setInt(2, comment.getCommentNo());
      count = pstmt.executeUpdate();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      try {
        if (pstmt != null)
          pstmt.close();
      } catch (Exception ex) {
      }
      try {
        if (conn != null)
          conn.close();
      } catch (Exception ex) {
      }
    }
    return count;
  }

}
