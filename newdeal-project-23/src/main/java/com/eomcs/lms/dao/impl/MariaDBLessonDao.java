package com.eomcs.lms.dao.impl;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component
public class MariaDBLessonDao implements LessonDao {
  
  private SqlSessionFactory sessionFactory;
  
  public MariaDBLessonDao(SqlSessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Map<String, Object>> findByParticipantNo(int mno) {
    try(SqlSession sqlSession = sessionFactory.openSession()){
      return sqlSession.selectList("LessonDao.findByParticipantNo", mno);
    }
  }

}
