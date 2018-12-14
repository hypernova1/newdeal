package prac;

public class AssertTest {
  public static void main(String[] args) {
    
    int a = -1;
    assert a > 0 : "a는 0보다 커야함";
    System.out.println(a);
  }
}
