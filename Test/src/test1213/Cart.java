package test1213;

public class Cart {
  private Product[] productList;
  private int cnt;
  
  public Cart() {
    productList = new Product[10];
  }

  public int getCnt() {
    return cnt;
  }
  
  public void addProduct(Product product) {
    productList[cnt++] = product;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public Product[] getProductList() {
    return productList;
  }

  public void setProductList(Product[] productList) {
    this.productList = productList;
  }
  
}
