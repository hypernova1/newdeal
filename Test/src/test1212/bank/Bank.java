package test1212.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<Account> accounts;
  private static int size;
  
  public Bank() {
    this.accounts = new ArrayList<>();
  }
  
  public void createAccount(Account account) {
    accounts.add(account);
    size++;
  }
  
  public Account searchByNo(int no) {
    return accounts.get(no);
  }
  
  public Account searchByName(String name) {
    Account reAccount = null;
    for(Account account : accounts) {
      if(account.getName().equals(name))
        reAccount = account;
    }
    return reAccount;
  }
  
  public List<Account> getAccountList(){
    return accounts;
  }
  
  public int getSize() {
    return size;
  }
  
}