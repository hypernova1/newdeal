## Mybatis 설정파일 추가

- mybatis-config.xml 작성
- jdbc.properties 파일 작성
    - DBMS 연결 정보를 둔다
    - Mybatis 설정파일에서 참고할 것임
- src/main/resources/com/eomcs/lms/conf 디렉토리에 파일을 둠
- src/main/resources 폴더를 추가한 후 자바 소스폴더로 등록해야 함(폴더를 만든 후 gradle eclipse)

## SQL 분리
- src/main/resources/com/eomcs/lms/mapper/BoardMapper.xml 파일 작성
- BoardDao 클래스에 있는 SQL 을  파일로 옮김

## SqlSessionFactory 인스턴스 생성
- App 클래스에서 Mabatis의 SqlSessionFactory 객체를 준비
- DAO 객체가 사용할 수 있도록 생성자에 주입