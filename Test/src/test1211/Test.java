package test1211;

import java.util.Scanner;

/*
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
 * 첫째 줄에 수의 개수 N(1<=N<10)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
 * 이 수는 절대값이 10보다 작거나 같은 정수이다.
 * 수는 중복되지 않는다.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한줄에 하나씩 출력한다.
*/
public class Test {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    int length = 0;
    System.out.println("1~10 사이의 숫자 입력");
    
    while(true) {
      length = Integer.parseInt(scan.nextLine());
      if(length > 0 && length <= 10) break;
      else System.out.println("다시 입력");
    }
    scan.close();
    
    int[] list = new int[length];
    for(int i = 0; i < list.length; i++) {
      list[i] = (int) (Math.random() * 10 + 1);
      
      for(int j = 0; j < i; j++) {
        if(list[j] == list[i]) {
          i--;
        }
      }
    }
    bubble(list);
    for(int i : list) {
      System.out.println(i);
    }
  }
  
  public static void bubble(int[] list) {
    for(int i = 0; i < list.length - 1; i++) {
      for(int j = 0; j < list.length - 1; j++) {
        if(list[j] > list[j+1]) {
          int temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
        }
      }
    }
  }
}
