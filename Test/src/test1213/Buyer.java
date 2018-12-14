package test1213;

public class Buyer {
  private int balance;
  private int point;
  private Cart cart;
  
  public Buyer() {
    this(1000);
  }
  public Buyer(int balance) {
    this.balance = balance;
    this.cart = new Cart();
  }
  
  public void buying(Product product) {
    if (cart.getCnt() < cart.getProductList().length) {
      cart.addProduct(product);
      System.out.println(product.toString() + "을 장바구니에 담았습니다..");
    } else {
      System.out.println("더 이상 담을 수 없습니다.");
    }

  }
  
  public void summary() {
    int totalPrice = 0;
    int totalPoint = 0;
    Product[] products = cart.getProductList();
    for(int i = 0; i < cart.getCnt(); i++) {
      System.out.println(i + "번째 제품");
      System.out.println("물건 이름: " + products[i]);
      System.out.println("물건 가격: " + products[i].price);
      totalPrice += products[i].price;
      totalPoint += products[i].bonuspoint;
    }
    if(totalPrice > balance) {
      System.out.println("잔액이 부족합니다.");
      return;
    }
    balance -= totalPrice;
    point += totalPoint;
    System.out.println("모두 구매하였습니다.");
  }

  public int getBalance() {
    return balance;
  }

  public int getPoint() {
    return point;
  }
}

class Product {
  int price;
  int bonuspoint;

  public Product() {}

  Product(int price) {
    this.price = price;
    this.bonuspoint = (int) (this.price / 10.0);
  }
}

class KtTv extends Product {
  KtTv() {
    super(500);
  }

  @Override
  public String toString() {
    return "KtTv";
  }
}


class Audio extends Product {
  Audio() {
    super(100);
  }

  @Override
  public String toString() {
    return "Audio";
  }
}


class NoteBook extends Product {
  NoteBook() {
    super(150);
  }

  @Override
  public String toString() {
    return "NoteBook";
  }
}
