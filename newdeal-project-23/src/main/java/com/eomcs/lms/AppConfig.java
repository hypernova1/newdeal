package com.eomcs.lms;

import java.util.Scanner;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

// Spring IoC 컨테이너에게 프로퍼티 파일 로딩 명령하기
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
@ComponentScan("com.eomcs.lms")
public class AppConfig {
  
  @Value("${jdbc.driver}")
  private String jdbcDriver;
  @Value("${jdbc.url}")
  private String jdbcUrl;
  @Value("${jdbc.username}")
  private String jdbcUsername;
  @Value("${jdbc.password}")
  private String jdbcPassword;
  
  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(jdbcDriver);
    dataSource.setUrl(jdbcUrl);
    dataSource.setUsername(jdbcUsername);
    dataSource.setPassword(jdbcPassword);
    
    return dataSource;
  }
  
  // 트랜잭션 객체생성시 기본 이름으로 transactionManager로 설정해야함
  // 다른이름으로 설정하게되면 트랜잭션 관련 다른 객체를 생성할 때 그 객체가 트랜잭션 관리자를 자동으로 찾지 못함 
  public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }
  
  @Bean
  public SqlSessionFactory sqlSessionFactory(
      DataSource dataSource, ApplicationContext iocContainer) throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    
    factoryBean.setDataSource(dataSource);
    
    // domain 클래스의 별명 자동 생성
    factoryBean.setTypeAliasesPackage("com.eomcs.lms.domain");
    // SQL 매퍼 파일 로딩
    // => SQL 매퍼 파일의 위치 정보를 Resource 객체에 담아서 넘김
    // => Resource 객체는 Spring IoC 컨테이너를 통해 생성 가능
    // => Spring IoC 컨테의너의 객체를 얻는 방법
    //    -> 이 메서드의 파라미터로 요청
    factoryBean.setMapperLocations(
        iocContainer.getResources("classpath:/com/eomcs/lms/mapper/*Mapper.xml"));
    
    return factoryBean.getObject();
  }
  
  @Bean
  public Scanner keyboard() {
    return new Scanner(System.in);
  }
}
