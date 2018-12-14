package test1212.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
  
  private int no;
  private String name;
  private int balance;
  private List<History> historys;
  private static int cnt;
  
  public Account(String name) {
    this.name = name;
    this.historys = new ArrayList<>();
    this.no = cnt++;
  }
  
  public void input(int money) {
    this.balance += money;
    
    History history = new History();
    history.setType("input");
    history.setValue(money);
    history.setValance(balance);
    
    historys.add(history);
  }
  public void output(int money) {
    this.balance -= money;
    
    History history = new History();
    history.setType("output");
    history.setValue(money);
    history.setValance(balance);
    
    historys.add(history);
  }

  public int getNo() {
    return this.no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getBalance() {
    return balance;
  }
  public void setBalance(int balance) {
    this.balance = balance;
  }
  public List<History> getHistorys() {
    return historys;
  }
  public void setHistorys(List<History> historys) {
    this.historys = historys;
  }

  @Override
  public String toString() {
    return "[계좌번호: " + no + ", 계좌주: " + name + ", 잔고: " + balance + "]";
  }
  
}
