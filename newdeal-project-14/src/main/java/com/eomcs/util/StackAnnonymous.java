package com.eomcs.util;

public class StackAnnonymous<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public StackAnnonymous() {
    maxSize = 100;
  }
  
  public StackAnnonymous(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public StackAnnonymous<E> clone() {
    StackAnnonymous<E> temp = new StackAnnonymous<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return temp;
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
    return new Iterator<>() {
      StackAnnonymous<E> stack;
      int count;
      
      {
       this.stack = StackAnnonymous.this.clone(); 
      }
      
      @Override
      public boolean hasNext() {
        return this.count < StackAnnonymous.this.size();
      }

      @Override
      public E next() {
        this.count++;
        return stack.pop();
      }
    };
  }
}
