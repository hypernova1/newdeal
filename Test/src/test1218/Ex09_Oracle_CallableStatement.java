package test1218;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

public class Ex09_Oracle_CallableStatement {

  public static void main(String[] args) {
    Connection conn = null;
    ResultSet rs = null;

    CallableStatement cstmt = null; // oracle procedure 사용시

    try {
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "KSC", "1111");

      String sql = "{call usp_emplist(?,?)}";
      cstmt = conn.prepareCall(sql); // prepare*: 미리 컴파일 후 파라미터만 넣음

      // usp_emplist(?,?)
      cstmt.setInt(1, 1000); //input 파라미터
      cstmt.registerOutParameter(2, OracleTypes.CURSOR); //output 파라미터

      boolean result = cstmt.execute();
      System.out.println(result);
      rs = (ResultSet) cstmt.getObject(2); // 주소 정보 얻어오기

      while (rs.next()) {
        System.out.println(rs.getInt(1) + "/" + rs.getString(2) + "/" + rs.getInt(3));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception e) {
        }
      if (cstmt != null)
        try {
          cstmt.close();
        } catch (Exception e) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception e) {
        }
    }
  }

}


