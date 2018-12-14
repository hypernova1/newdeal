package test1214;

public class MyStack<T> {
  
  private T[] stackArr;
  private int size;
  
  @SuppressWarnings("unchecked")
  public MyStack(int arrSize) {
    stackArr = (T[]) new Object[arrSize];
  }
  
  public boolean empty() { // 스택이 비었는지 확인
    if(size == 0) return true;
    return false;
  }
  
  public boolean full() { //스택이 풀인지 확인
   if(stackArr.length == size) return true;
   return false;
  }
  
  public void push(T obj) {
    if(stackArr.length == size) {
      for(int i = 1; i < size; i++) {
        stackArr[i - 1] = stackArr[i];
      }
      stackArr[size - 1] = obj;
      return;
    }
    stackArr[size++] = obj;
  }
  
  public T pop() {
    if(size == 0) return null;
    size--;
    T obj = stackArr[size];
    stackArr[size] = null;
    return obj;
    
  }
  public int size() {
    return size;
  }
  
  public static void main(String[] args) {
    MyStack<Integer> s = new MyStack<>(10);
    for(int i = 0; i < 12; i++) {
      s.push(i);
    }
    
    System.out.println(s.size());
    System.out.println("----------------------");
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    
  }
 }