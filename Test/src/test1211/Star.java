package test1211;
import java.util.Scanner;
/*
 *입력받은 정수값을 다른클래스에 전달해준뒤 입력한 별의 갯수만큼 별을 쌓아주시면 됩니다.
 *조건은 별짓기를 할때 사용할 제어문은 for문 2개만 사용해서 만들수있습니다.
 *(if,switch등 다른제어문 사용X) 
*/
 
public class Star {
    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.printf("별 갯수를 입력하세요");
      
      int num = Integer.parseInt(keyboard.next());
      
      keyboard.close();
      
      new StarCreate().getStar4(num);
    }
}