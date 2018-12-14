package test1213;

public class BuyerTest {
  public static void main(String[] args) {
    
    Buyer b = new Buyer(1500);
    KtTv ktTv = new KtTv();
    Audio audio = new Audio();
    NoteBook noteBook = new NoteBook();
    
    b.buying(ktTv);
    b.buying(ktTv);
    b.buying(ktTv);
    b.summary();
    
    
    System.out.println("적립된 총 포인트: " + b.getPoint());
    System.out.println("잔고: " + b.getBalance());
    
  }
}
