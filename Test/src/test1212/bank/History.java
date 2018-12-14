package test1212.bank;

import java.util.Calendar;
import java.util.Date;

public class History {
  private Calendar date;
  private String type;
  private int value;
  private int valance;
  
  public History() {
    this.date = Calendar.getInstance();
  }
  
  public Date getDate() {
    return date.getTime();
  }
  public void setDate(Calendar date) {
    this.date = date;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public int getValue() {
    return value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  public int getValance() {
    return valance;
  }
  public void setValance(int valance) {
    this.valance = valance;
  }

  @Override
  public String toString() {
    return "[일자: " + date.getTime() + ", 타입: " + type + ", 금액: " + value + ", 잔고: " + valance
        + "]";
  }
  
}
