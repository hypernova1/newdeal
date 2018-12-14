package prac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class StringTest implements Cloneable {
  public static void main(String[] args) {
    
    String[] a = new String[4];
    
    a[0] = "aa"; //리터럴로 생성할 경우 자동적으로 intern메소드가 호출됨
    a[1] = "aa"; //intern(): 문자열이 상수풀에 있는지 확인후 있다면 리턴해줌
    a[2] = new String("aa").intern();
    
    a[3] = "aa";
    
    
    Object str = null;

    if(Objects.isNull(str)) {
      System.out.println("dd");
    }
    
    List<HashMap<String, Object>> arr = new ArrayList<>(Arrays.asList(new HashMap<>(),new HashMap<>()));
   
    
    System.out.println(arr.get(0));    
  }
}
