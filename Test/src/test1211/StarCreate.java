package test1211;

public class StarCreate {

  public void getStar(int num) {
    for(int i = 0; i < num; i++) {
      String star = "";
      star += "*";
      System.out.println(star);
    }
  }
  
  public void getStar2(int num) {
    for(int i = 0; i < num; i++) {
      for(int j = num - i; j > 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
  
  public void getStar3(int num) {
    String temp = "";
    for(int i = 0; i < num; i++) {
      String star = "";
      for(int j = num - i; j > 0; j--) {
        star += "*";
      }
      System.out.println(temp + star);
      temp += " ";
    }
  }
  
  public void getStar4(int num) {
    
    for(int i = num - 1; i > 0; i--) {
      System.out.print("");
      for(int j = 0; j < 0; j++) {
        
      }
    }
    
    
  }
}   
