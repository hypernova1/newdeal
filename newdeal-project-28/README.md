## CharaterEncodingFilter를 스프링에서 제공하는 클래스로 교체

## JSP 파일을 클라이언트로부터 감추기
- 외부에서 JSP를 직접 접근하지 못하게 /WEB-INF/jsp 폴더로 옮긴다.

## 기존의 ViewResolver를 InternalViewResolver로 교체
- AppConfig.java
    - 객체 생성 메서드 추가

## 페이지 컨트롤러의 리턴값 변경


※ 파라미터로 HttpServletRequest, response를 받았을 땐 컨트롤러 리턴값으로 void 를 주면 view를 찾지 못했는데
    일반 스프링에서 제공하는 객체로 받으니 다시 찾았다