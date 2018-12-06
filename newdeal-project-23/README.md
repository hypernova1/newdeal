## 웹 프로젝트 관련 빌드 명령을 설정할 수 있게 준비
- build.gradle
    - 'eclipse' 플러그인 대신 'eclipse-wtp' 추가
    - 웹 애플리케이션 배포 파일(.war)을 만들 'war' 플러그인 추가
    - 단독으로 실행할 수 없기 때문에 기존 'application' 플러그인 제거
    - 'application' 플러그인과 과련된 변수 'mainClassName'을 제거

## 서블릿 애플리케이션 개발에 사용할 라이브러리 추가
- servlet-api

## 이클립스 웹 프로젝트 설정 파일 준비하기
- src/main/webapp
    - HTML, CSS, JavaScript, PNG, JPEG, JSP등 웹 자원을 둘 디렉토리 생성
- index.html
    - 웹 애플리케이션에 대해 간단히 소개하는 웹 페이지를 만든다.
- gradle eclipse로 설정 갱신
    - 'src/main/webapp'이 웹 프로젝트에 등록 됨

## 이클립스에 톰캣 서버 등록
- 환경설정
    - 톰캣 서버가 설치된 디렉토리 정보 등록
- 웹 애플리케이션 테스트 환경 추가
    - 'Servers' 뷰에 톰캣 테스트 환경 구축

## JSTL 환경 구축
- JSTL 구현 라이브러리를 가져온다.

## MVC 아키텍처 적용

## HttpSession을 이용한 로그인/로그아웃

## Filter를 이용하여 서블릿 실행 전 작업 수행