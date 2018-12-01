package com.eomcs.util;

public class StackInnerClass<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public StackInnerClass() {
    maxSize = 100;
  }
  
  public StackInnerClass(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public StackInnerClass<E> clone() {
    StackInnerClass<E> temp = new StackInnerClass<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (StackInnerClass<E>) temp;
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

    StackInnerClass<E> stack;
    int count;
    
    {
     this.stack = StackInnerClass.this.clone(); 
    }
    
    @Override
    public boolean hasNext() {
      return this.count < StackInnerClass.this.size();
    }

    @Override
    public E next() {
      this.count++;
      return stack.pop();
    }
  }
}
