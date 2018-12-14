package prac;

public interface InterfaceTest {
  void print();
}


class SuperClass implements InterfaceTest {
  
  @Override
  public void print() {}
  public void print2() {}

}

class A extends SuperClass{

  public void a() {
    super.print();
    this.print();
  }
  
}