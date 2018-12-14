package prac;
public class Lamda{
  
  static int a;
  
  static {
    a = 100;
    System.out.println("정적 블록");
  }
  
  public static void main(String[] args) {
    int b = Lamda.a;
    System.out.println(b);
    
  }
  
}
