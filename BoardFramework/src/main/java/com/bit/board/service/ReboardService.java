package com.bit.board.service;

import java.util.List;
import java.util.Map;
import com.bit.board.model.ReboardDto;

public interface ReboardService {
  int writeArticle(ReboardDto reboardDto);
  List<ReboardDto> listArticle(Map<String, Object> param);
  ReboardDto viewArticle(int rseq);
  int replyArticle(ReboardDto reboardDto);
  
  void modifyArticle(ReboardDto reboardDto);
  void deleteArticle(int rseq);
}
