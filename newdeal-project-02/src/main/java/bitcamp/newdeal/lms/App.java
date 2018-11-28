package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
      Scanner keyIn = new Scanner(System.in);
      
      System.out.println("번호?");
      int no = Integer.parseInt(keyIn.nextLine());
      
      System.out.println("수업명?");
      String title = keyIn.nextLine();
      
      System.out.println("내용?");
      String contents = keyIn.nextLine();
      
      System.out.println("강의 시작일?");
      Date startDate = Date.valueOf(keyIn.nextLine());

      System.out.println("강의 종료일?");
      Date endDate = Date.valueOf(keyIn.nextLine());
      
      System.out.println("총 강의 시간?");
      int totalHours= Integer.parseInt(keyIn.nextLine());
      
      System.out.println("일 강의 시간?");
      int dayHours = Integer.parseInt(keyIn.nextLine());
      
      keyIn.close(); //자원 해제
      
      System.out.println("번호: " + no);
      System.out.printf("수업명: %s\n", title); //이스케이프 문자: 문자열 안에 삽입되는 명령어
      System.out.printf("내용: %s\n", contents);
      System.out.printf("시작일: %s\n", startDate);
      System.out.printf("종료일: %s\n", endDate);
      System.out.printf("총 수업 시간: %d\n", totalHours);
      System.out.printf("일 수업 시간: %d", dayHours);
      
    }
}
