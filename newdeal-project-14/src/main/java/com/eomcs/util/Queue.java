package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public Queue() {
    maxSize = 100;
  }
  
  public Queue(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public Queue<E> clone() {
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Queue<E>) temp;
  }
  
  public void offer(E value) {
    if (size() == maxSize)
      remove(0); // 꽉차면 맨 앞에 입력된 값을 제거한다.
    add(value);
  }
  
  public E poll() {
    if (size() > 0)
      return remove(0);
    return null;
  }
  
  public Iterator<E> iterator() {
    return new IteratorImpl();
  }
  
  //중첩 클래스
  class IteratorImpl implements Iterator<E> {

    Queue<E> queue;
    int count;
    
    {
      this.queue = Queue.this.clone();
    }
    
    @Override
    public boolean hasNext() {
      return this.count < Queue.this.size();
    }

    @Override
    public E next() {
      this.count++;
      return queue.poll();
    }
    
  }
}
