package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    System.out.println("번호?");
    int no = Integer.parseInt(scan.nextLine());
    
    System.out.println("이름?");
    String name = scan.nextLine();
    
    System.out.println("이메일?");
    String email = scan.nextLine();
    
    System.out.println("암호?");
    String pw = scan.nextLine();
    
    System.out.println("사진?");
    String pic = scan.nextLine();
    
    System.out.println("전화?");
    String phone = scan.nextLine();
    
    System.out.println("가입일?");
    
    scan.close();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    String date = sdf.format(new Date());
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", pw);
    System.out.printf("사진: %s\n", pic);
    System.out.printf("전화: %s\n", phone);
    System.out.printf("가입일: %s\n", date);
  }
}
