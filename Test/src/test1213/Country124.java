package test1213;

import java.util.Scanner;

public class Country124 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] c124 = {4, 1, 2};
    String value = "";
    
    System.out.print("숫자를 입력하세요. ");
    int number = Integer.parseInt(sc.nextLine());
    
    while (number > 0) {
      int temp1 = number % 3;
      value = c124[temp1] + value;
      number = (number-1)/3;
    }
    System.out.println("124 나라의 숫자는? " + value);
    sc.close();
  }
}
