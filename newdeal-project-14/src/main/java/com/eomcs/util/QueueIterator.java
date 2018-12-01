package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {

  private Queue<E> queue;
  private int count;
  private int size;
  
  public QueueIterator(Queue<E> queue){
    this.queue = queue.clone();
    this.size = queue.size();
  }
  
  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return queue.poll();
  }

}
