package com.eomcs.lms.dao;

import java.sql.SQLException;
import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {
  List<Board> findAll() throws SQLException;
  Board findByNo(int no) throws SQLException;
  int insert(Board board) throws SQLException;
  int update(Board board) throws SQLException;
  int delete(int no) throws SQLException;

}
