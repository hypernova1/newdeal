package com.eomcs.lms;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext iocContainer =
        new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);
    iocContainer.refresh();

    servletContext.addListener(new ContextLoaderListener(iocContainer));

    DispatcherServlet servlet = new DispatcherServlet(iocContainer);

    ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
    registration.setLoadOnStartup(1);
    registration.addMapping("/app/*");

    // 필터 세팅
    FilterRegistration charEncodingFilterReg =
        servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);

    charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
    charEncodingFilterReg.setInitParameter("forceEncoding", "true");
    charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/app/*");
  }

}
