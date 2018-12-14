package test1211;

import java.util.Scanner;

//주어진 숫자 중 입력받은 숫자와 가장 가까운 수 찾기
public class Algorithm {
  public static void main(String[] args) {
    int[] data = {10,20,30,27,17};

    Scanner scan = new Scanner(System.in);
    System.out.println("숫자 입력");
    int num = scan.nextInt();
    scan.close();
    
    int min = Integer.MAX_VALUE;
    int val;
    int result = 0;
    for(int i = 0; i < data.length; i++) {
      val = abs(num - data[i]);
      if(min > val) {
        min = val;
        result = data[i];
      }
    }
    System.out.println(result);

  }
  
  public static void myQ(int num, int[] data) {
    
    int[] result = new int[data.length];
    
    for(int i = 0; i < data.length; i++) {
      result[i] = abs(num - data[i]);
    }
    
    int minIndex = 0;
    int minValue = result[minIndex];
    
    for(int i = 0; i < result.length; i++) {
      if(minValue > result[i]) {
        minValue = result[i];
        minIndex = i;
      }
    }
    
    System.out.println(data[minIndex]);
  }
  
  public static int abs(int num) {
    if(num > 0) return num;
    
    return -num;
  }
}
