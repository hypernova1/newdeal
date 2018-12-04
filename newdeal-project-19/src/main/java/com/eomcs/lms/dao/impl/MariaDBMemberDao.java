package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {

    try (
        Connection conn =
            DriverManager.getConnection("jdbc:mariadb://localhost:3307/studydb", "study", "1111");
        PreparedStatement ps = conn.prepareStatement(
            "SELECT mno name, email, photo" + " FROM member" + " WHERE email=? and pwd=?'");) {
      ps.setString(1, email);
      ps.setString(2, password);

      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPhoto(rs.getString("photo"));
          return member;
        } else {
          return null;
        }
      }
    }

  }
}
