package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("번호?");
    int no = Integer.parseInt(scan.nextLine());
    
    System.out.println("내용?");
    String contents = scan.nextLine();
    
    scan.close();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String date = sdf.format(new Date());
    
    int view = 0;
    
    System.out.printf("번호: %d\n내용: %s\n등록일: %s\n조회수: %d", no, contents, date, view);
    
  }
}
