package com.bit.common.dao;

public interface CommonDao {
  int getNextSeq();
  void increaseHit(int seq);
}
