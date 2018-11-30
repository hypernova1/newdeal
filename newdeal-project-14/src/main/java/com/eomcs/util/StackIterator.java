package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {

  private StackInnterClass<E> stack;
  private int size;
  private int count;
  
  public StackIterator(StackInnterClass<E> stack){
    this.stack = stack;
    this.size = stack.size();
  }
  
  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return stack.pop();
  }

}
