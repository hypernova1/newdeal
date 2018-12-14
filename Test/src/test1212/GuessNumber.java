package test1212;

import java.util.Scanner;

//난수 0~99까지의 임의의 수가 정해지고, 정해진 수를 맞추는 게임입니다.
//만약 정해진 수가 77인 경우, 55라고 입력하면 더 높게, 80은 낮게 y/n 묻고 n 입력시 종료
public class GuessNumber {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int randomNo = (int) (Math.random() * 99 + 1);
    boolean yn = true;
    String result = "";
    
    System.out.println("숫자가 정해졌습니다. 답을 입력하세요. (1 ~ 99)");
    while(yn) {
      result = scan.nextLine();
      
      if(Integer.parseInt(result) > randomNo) System.out.println("더 작은 수 입력");
      else if(Integer.parseInt(result) < randomNo) System.out.println("더 큰 수 입력");
      else {
        System.out.println("정답 다시? (y/n)");
        result = scan.nextLine();
        if (result.equals("y")) {
          System.out.println("숫자 재정의");
          randomNo = (int) (Math.random() * 99 + 1);
        } else if(result.equals("n")) yn = false;
      }
    }
    System.out.println("종료");
    scan.close();
  }
}
