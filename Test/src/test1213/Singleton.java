package test1213;

public class Singleton {
  private static Singleton instance;
  
  private Singleton() {}
  
  public static Singleton getInstence() {
    if(instance != null) return instance;
    instance = new Singleton();
    return instance;
  }
  
  public int add(int a, int b) {
    return a + b;
  }
  
  public static void main(String[] args) {
    Singleton s1 = Singleton.getInstence();
    Singleton s2 = Singleton.getInstence();
    Singleton s3 = Singleton.getInstence();
    System.out.println(s1.add(1, 2));
    
    System.out.println(s1 == s2); //true
    System.out.println(s2 == s3); //true
    System.out.println(s1 == s3); //true
  }
}
