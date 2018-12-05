package com.eomcs.lms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//Spring IoC 컨테이너에게 패키지 이름을 알려주면
//그 패키지를 뒤져서 @Component가 붙은 클래스에 대해 인스턴스를 자동으로 생성
@ComponentScan("com.eomcs.lms")
public class AppConfig {

  // IoC 컨테이너에게 이 메서드를 호출하여 리턴 값을 보관하라고 지시
  // => 리턴값을 저장할 때 사용할 이름을 따로 지정하지 않으면, 메서드 이름으로 저장
  // => 그래서 이런 메서드의 이름은 보통 동사로 시작하지 않고, 객체의 이름인 명사 형태로 지음
  @Bean//("sqlSessionFactory")
  public SqlSessionFactory sqlSessionFactory() throws IOException {
    String resource = "com/eomcs/lms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    return new SqlSessionFactoryBuilder().build(inputStream);
  }
  
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
}
