package test1218;

public class CompactedString {
  
  public static void main(String[] args) {
    System.out.println(method("aaaaaabbc")); //a6b2c1
  }

  public static String method(String input) {
    String word = String.valueOf(input.charAt(0));
    String words = "";
    int cnt = 1;
    for(int i = 0; i < input.length() - 1; i++) {
      if(input.charAt(i) == input.charAt(i + 1)) {
        cnt++;
      } else {
        words += (word + cnt);
        cnt = 1;
        word = String.valueOf(input.charAt(i + 1));
      }
    }
    words += (word + cnt);
    
    return words;
  }
  
  /*public static String method(String words) { // aaabcc

    int cnt = 1;
    int index = 0;
    String[] arrStr = new String[words.length()];
    for(int i = 0; i < words.length(); i++) {
      if(i == words.length() - 1) {
        arrStr[index] = words;
        break;
      }
      if(words.charAt(i) == words.charAt(i + 1)) {
        cnt++;
      } else {
        arrStr[index++] = words.substring(0, cnt);
        words = words.substring(cnt, words.length());
        cnt = 1;
        i = -1;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(String a : arrStr) {
      if(a == null) break;
      sb.append(a.charAt(0) + "" + a.length());
    }
    
    return sb.toString();
    
  }*/
  
}
