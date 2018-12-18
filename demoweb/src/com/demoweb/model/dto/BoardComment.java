package com.demoweb.model.dto;

import java.util.Date;

public class BoardComment {

  private int commentNo;
  private int boardNo;
  private String writer;
  private String content;
  private String regDate;
  public int getCommentNo() {
    return commentNo;
  }
  public void setCommentNo(int commentNo) {
    this.commentNo = commentNo;
  }
  public int getBoardNo() {
    return boardNo;
  }
  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getRegDate() {
    return regDate;
  }
  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }
  
  
}