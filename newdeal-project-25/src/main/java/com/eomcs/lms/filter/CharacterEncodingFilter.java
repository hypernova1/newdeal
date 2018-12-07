package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    // POST 요청으로 들어온 데이터는 UTF-8 이지만 request.getParameter()의 리턴값은 Unicode(2byte)이다.
    // 문제는 클라이언트가 보낸 데이터를 명시적으로 알리지 않으면 getParameter는 클라이언트가 보낸 데이터를 ISO-8859-1로 적용함
    // 즉 영어로 인식하고 Unicode로 바꾸는 것
    // 최초로 데이터를 받기 전에 설정을 해줘야 함
    request.setCharacterEncoding("UTF-8");
    
    //다음 필터가 있다면 그 필터를 실행, 없다면 서블릿 실행
    chain.doFilter(request, response);
  }

}
