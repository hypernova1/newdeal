package com.eomcs.lms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;

// 웹 애플리케이션이 시작되거나 종료될 때 호출되는 메서드를 정의한 클래스
// 톰캣 서버에 등록
@WebListener
public class ContextLoaderListener implements ServletContextListener {

  AnnotationConfigApplicationContext iocContainer;
  
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("웹 애플리케이션 시작");
    
    // Spring IoC 컨테이너 준비
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);

/*  
    System.out.println(iocContainer.getBeanDefinitionCount());

    String[] names = iocContainer.getBeanDefinitionNames();

    for (String name : names) {
      System.out.printf("%s ==> %s\n", name,
          iocContainer.getBean(name).getClass().getName());
    }
*/
    
    // Spring IoC 컨테이너를 서블릿이 사용할 수 있도록 'ServletContext'에 저장
    ServletContext sc = sce.getServletContext();
    sc.setAttribute("iocContainer", iocContainer);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    //Spring IoC 컨테이너의 자원을 해제
    iocContainer.close();

    System.out.println("웹 애플리케이션 종료");
  }

}
