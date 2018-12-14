package test1212.bank;

import java.util.List;

public class BankTest {

  public static void main(String[] args) {
    
    Bank bank = new Bank(); //은행 생성
    bank.createAccount(new Account("kim")); //은행에 등록
    
    Account kimsAcc = bank.searchByName("kim");
    kimsAcc.input(100); //입금
    kimsAcc.output(10); //출금
    kimsAcc.input(70);

    List<History> accList = kimsAcc.getHistorys(); //account 인스턴스의 히스토리 가져오기
    
    for(History his : accList) { //히스토리 출력
      System.out.println(his);
    }
    
  }

}
