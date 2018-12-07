package com.eomcs.lms.domain;
import java.sql.Date;

public class Lesson implements Cloneable {
  private Integer no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private Integer totalHours;
  private Integer dayHours;
  private Integer ownerNo;
  
  @Override
  public Lesson clone() throws CloneNotSupportedException {
    return (Lesson) super.clone();
  }
  
  public Integer getOwnerNo() {
    return ownerNo;
  }
  
  public void setOwnerNo(Integer ownerNo) {
    this.ownerNo = ownerNo;
  }
  public Integer getNo() {
    return no;
  }
  public void setNo(Integer no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Integer getTotalHours() {
    return totalHours;
  }
  public void setTotalHours(Integer totalHours) {
    this.totalHours = totalHours;
  }
  public Integer getDayHours() {
    return dayHours;
  }
  public void setDayHours(Integer dayHours) {
    this.dayHours = dayHours;
  }
  
  
}
