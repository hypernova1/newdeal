package test1214;

public class Anagram {
  public static void main(String[] args) {
    String origin = "String";
    String duplicate = "gnirtS";
  
    System.out.println(anagram(origin, duplicate));

    
  }
  
  public static boolean anagram(String a, String b){
    boolean result = false;
    
    if(a.length() != b.length()) return result;
    
    for(int i = 0; i < a.length(); i++){
      if(a.indexOf(b.charAt(i) + "") == -1){
        result = false;
        break;
      }
      result = true;
    }
    return result;
  }
  
}
