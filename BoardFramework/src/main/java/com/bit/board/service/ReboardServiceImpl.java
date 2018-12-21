package com.bit.board.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bit.board.dao.ReboardDao;
import com.bit.board.model.ReboardDto;
import com.bit.common.dao.CommonDao;
import com.bit.util.BoardConstance;

@Service
public class ReboardServiceImpl implements ReboardService {

  @Autowired
  private SqlSession sqlSession;
  
  public ReboardServiceImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }
  
  @Override
  public int writeArticle(ReboardDto reboardDto) {
    int seq = sqlSession.getMapper(CommonDao.class).getNextSeq();
    reboardDto.setSeq(seq);
    reboardDto.setRef(seq);
    int cnt = sqlSession.getMapper(ReboardDao.class).writeArticle(reboardDto);
    return cnt != 0 ? seq : 0;
  }

  @Override
  public List<ReboardDto> listArticle(Map<String, Object> param) {
    int page = Integer.parseInt((String) param.get("page"));
    int end = page * BoardConstance.LIST_CNT.getValue();
    int start = end - BoardConstance.LIST_CNT.getValue();
    param.put("start", start + "");
    param.put("end", end + "");
    return sqlSession.getMapper(ReboardDao.class).listArticle(param);
  }

  @Override
  public ReboardDto viewArticle(int rseq) {
    ReboardDto reboardDto = sqlSession.getMapper(ReboardDao.class).viewArticle(rseq);
    if(reboardDto != null) {
      reboardDto.setContent(reboardDto.getContent().replace("\n", "<br>"));
      sqlSession.getMapper(CommonDao.class).increaseHit(rseq);
    }
    return reboardDto;
  }

  @Override
  public int replyArticle(ReboardDto reboardDto) {
    return 0;
  }

  @Override
  public void modifyArticle(ReboardDto reboardDto) {
    
  }

  @Override
  public void deleteArticle(int rseq) {
    
  }
  
  @SuppressWarnings("unused")
  public int StringToInt(String tmp) {
    boolean flag = true;
    if(tmp != null) {
      int len = tmp.length();
      for(int i = 0; i < len; i++) {
        char a = (char) (tmp.charAt(i) - 48);
      }
    }
    return 0;
  }

}
