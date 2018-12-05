package com.eomcs.lms.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component
public class MariaDBMemberDao implements MemberDao {

private SqlSessionFactory sqlSessionFactory;
  
  public MariaDBMemberDao(SqlSessionFactory sqlSessionFactory) throws SQLException {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public Member findByEmailPassword(String email, String password) throws SQLException {
    Map<String, Object> params = new HashMap<>();
    
    params.put("email", email);
    params.put("password", password);
    
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      return sqlSession.selectOne("MemberDao.findByEmailPassword", params);
    }
  }
}
