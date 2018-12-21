package com.bit.util;

public enum BoardConstance {
  LIST_CNT(20), PAGE_CNT(20);
  
  private int value;
  private BoardConstance(int value) {
    this.value = value;
  }
  public int getValue() {
    return value;
  }
  
}
