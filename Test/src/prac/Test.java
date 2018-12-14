package prac;
import java.util.HashMap;
import java.util.Map;

public class Test {
  
  Integer a = 1;
  
  public static void main(String[] args) {
    
    System.out.println(new Test().a);
    int a = 0b01101001;
    
    System.out.println(a);
    
    int b = 1;
    
    System.out.println(b++ + b++ + --b);
    a(a);
    
    System.out.println(a);
    int x = 0;
    
    if(x == 1) {
      myloof:
      if(x == 2)
        break myloof;
    }
    
    Map<String, Object> map = new HashMap<>();
    map.put("a", "aa");
    
    System.out.println(String.class.getMethods().length);
    
    
  }
  
  static void a(int a) {
    a = 100;
  }
}
