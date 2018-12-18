package test1218;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OracleTypes;

public class Ex10_Oracle_CallableStatement_dml {

  public static void main(String[] args) {

    try (Connection conn = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:XE", "KSC", "1111");
        CallableStatement cstmt = conn.prepareCall("{call usp_insert_emp(?,?,?,?)}");){
      Class.forName("oracle.jdbc.OracleDriver");

      cstmt.setInt(1, 9999); //input 파라미터
      cstmt.setString(2, "hong");
      cstmt.setString(3, "IT");
      cstmt.registerOutParameter(4, OracleTypes.VARCHAR); //output 파라미터
      cstmt.execute();

      String oraclemsg = (String) cstmt.getObject(4); //아웃풋 받기

      System.out.println("DB 메시지 : " + oraclemsg);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}


