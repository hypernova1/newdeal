package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    final int DEFAULT_SIZE = 10;
    
    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] pw = new String[DEFAULT_SIZE];
    String[] pic = new String[DEFAULT_SIZE];
    String[] phone = new String[DEFAULT_SIZE];
    String[] regDate = new String[DEFAULT_SIZE];
    
    String lowEmail = null;
    
    String input = "";
    int i = 0;
    int len = 0;
    
    while(!input.equalsIgnoreCase("n")) {
      
      System.out.println("번호?");
      no[i] = Integer.parseInt(scan.nextLine());
      
      System.out.println("이름?");
      name[i] = scan.nextLine();
      
      System.out.println("이메일?");
      lowEmail = scan.nextLine();
      int empty = 30 - lowEmail.length();
      String emptyStr = "";
      for(int k = 0; k < empty; k++) {
        emptyStr += " ";
      }
      
      email[i] = lowEmail + emptyStr;
      
      
      System.out.println("암호?");
      pw[i] = scan.nextLine();
      
      System.out.println("사진?");
      pic[i] = scan.nextLine();
      
      System.out.println("전화?");
      phone[i] = scan.nextLine();
      
      System.out.println("계속하시겠습니까?");
      input = scan.nextLine();
      
      regDate[i] = sdf.format(new Date());
      
      len++;
      i++;
      
      if(input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      scan.close();
      break;
    }
    for(int j = 0 ; j < len ; j++) {
      System.out.printf("%d, %s, %s, %s, %s\n", no[j], name[j], email[j], phone[j], regDate[j]);
    }
    
  }
}
