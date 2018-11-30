package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  
  private static final int LENGTH = 10;
  private Board[] list;
  private int size = 0;
  
  public BoardList() {
    list = new Board[LENGTH];
  }
  
  public BoardList(int initialCapacity) {
    if(this.size < initialCapacity)
      list = new Board[initialCapacity];
    else
      list = new Board[LENGTH];
  }
  
  public Board[] toArray() {
    return Arrays.copyOf(list, size);
  }
  
  public void add(Board board) {
    if(this.size >= list.length) {
      int oldLength = list.length;
      int newCapacity = oldLength + (oldLength * oldLength >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    list[size] = board;
    size++;
  }
  
  
}
