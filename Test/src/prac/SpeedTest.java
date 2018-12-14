package prac;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpeedTest {
  public static void main(String[] args) {
    
    LinkedList<String> s = new LinkedList<>();
    ArrayList<String> arr = new ArrayList<>();
    
    long sStart = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) {
      s.add("" + i);
    }
    for(int i = 0; i < 1000000; i++) {
      s.get(i);
    }
    long sFinish = System.currentTimeMillis();
    System.out.println(sFinish - sStart);
    
    long arrStart = System.currentTimeMillis();
    for(int i = 0; i < 1000000; i++) {
      arr.add("" + i);
    }
    for(int i = 0; i < 1000000; i++) {
      arr.get(i);
    }
    long arrFinish = System.currentTimeMillis();
    System.out.println(arrFinish - arrStart);
    
    
  }
}
