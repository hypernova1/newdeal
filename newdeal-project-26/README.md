## Spring WebMVC 라이브러리 가져오기
- spring-webmvc 라이브러리 추가

## Spring WebMVC의 프론트 컨트롤러 설정하기
- MyWebApplicationInitializer.java
    - WebApplicationInitializer 구현체 생성
    - Spring IoC 컨테이너와 DispatcherServlet 준비

## 기존의 DispatcherServlet 제거

## 기존의 ContextLoaderListener 제거
- Spring에서 제공한 DispatcherServlet은 자체적으로 IoC 컨테이너를 다루기 때문에 필요 없음

## PageController 제거
- Spring의 DispatcherServlet이 페이지 컨트롤러를 실핼할 때는 다른 규칙에 따라 실행함

## 기존의 페이지 컨트롤러를 변경한다.
- Spring의 DispatcherServlet에 맞춰서 페이지 컨트롤러를 변경