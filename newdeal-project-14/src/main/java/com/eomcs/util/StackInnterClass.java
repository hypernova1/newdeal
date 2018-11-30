package com.eomcs.util;

public class StackInnterClass<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public StackInnterClass() {
    maxSize = 100;
  }
  
  public StackInnterClass(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public StackInnterClass<E> clone() {
    StackInnterClass<E> temp = new StackInnterClass<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (StackInnterClass<E>) temp;
  }
  
  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }
  
  public E pop() {
    return remove(size() - 1);
  }
  
  public Iterator<E> iterator() {
    return new StackIterator();
  }
  
  // FIXME: 내부 제네릭 클래스는 외부 제네릭 클래스의 타입을 따라가서 따로 명시를 안해도 인식하는 듯..?
  class StackIterator implements Iterator<E> {

    StackInnterClass<E> stack;
    int count;
    
    {
     this.stack = StackInnterClass.this.clone(); 
    }
    
    @Override
    public boolean hasNext() {
      return this.count < StackInnterClass.this.size();
    }

    @Override
    public E next() {
      this.count++;
      return stack.pop();
    }
  }
}
