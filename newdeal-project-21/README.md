## Spring IoC Container 라이브러리 추가
- spring-context 라이브러리 추가

## Spring IoC 설정
- AppConfig.java 작성
    - SqlSessionFactory 객체 생성하는 메서드 추가
        - Spring IoC 컨테이너가 자동으로 객체를 생성할 수 없는 경우 메서드를 정의하여 직접 객체를 리턴
        - Dao나 Command의 경우엔 개발자 정의한 것이기 때문에 Spring IoC 컨테이너를 통해 객체를 자동 생성할 수 있다.
        - 그러나 MyBatis 관련 객체의 경우 개발자가 만든 클래스가 아니라서 Spring IoC 컨테이너가 자동 생성 할 수 없다.
        - 따라서 MyBatis 관련 클래스는 직접 인스턴스를 생성해야한다.
    - DAO, Command 클래스에 객체를 자동 생성하도록 설정
        - 클래스 선언부에 @Component를 붙인다.

## Spring IoC 컨테이너 준비
- App.java
    - Spring IoC 컨테이너 객체를 준비한다.