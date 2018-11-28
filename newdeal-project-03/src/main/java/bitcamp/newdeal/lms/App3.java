package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    final int DEFAULT_SIZE = 10;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    int[] no = new int[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    String[] regDate = new String[DEFAULT_SIZE];
    
    int view = 0;
    int len = 0;
    
    String input = "";
    for(int i = 0; i < DEFAULT_SIZE; i++) {
      
      System.out.println("번호?");
      no[i] = Integer.parseInt(scan.nextLine());
      
      System.out.println("내용?");
      contents[i] = scan.nextLine();
      
      regDate[i] = sdf.format(new Date());
      
      len++;
      
      System.out.println("계속 하시겠습니까?(Y/N)");
      input = scan.nextLine();
      
      if(input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      scan.close();
      
      break;
    }
    
    for(int i = 0; i < len; i++) {
      System.out.printf("%d, %s, %s, %d\n", no[i], contents[i], regDate[i], view);
    }

    /*
     * 번호? 1
     * 내용? 게시글입니다.
     * 
     * 
     * 1, 게시글입니다.              , 2019-01-01, 0
     */
  }
}
