# SpringBoot_RoadMap _ Spring_introduction




# Spring start io 사이트

Maven vs Gradle  = 라이브러리를 가져오고 라이플사이클을 관리해주는 툴
Group = 보통 기업명
Artifact =빌드된 결과물





# Project 구조

.idea = 인텔리제이 설정파일
gradle = gradle 파일
src = main 과 test코드
main - resources = 설정파일

## build.gradle = gradle 설정파일
gitignore = 깃에 올리지 않는 파일 설정
톰캣 = 스프링부트 내장서버

log파일 = 에러 및 출력 내역 확인





# 라이브러리

spring-boot-starter-web
  * spring-boot-starter-tomcat = 톰캣(웹서버)
  * spring-webmvc = 스프링 웹 mvc

spring-boot-starter-thymeleaf = 타임리프 템플릿 엔진
spring-boot-starter(공통) = 스프링부트 + 스프링코어 + 로깅
  * spring-boot
        *spring-core
  * spring-boot-starter-logging
        *logback , sif4j

spring-boot-starter-test = 스프링부트 테스트 라이브러리
  * junit = 테스트 프레임워크
  * mockito = 목 라이브러리
  * assertj = 테스트 코드를 편하게 작성하게 도와주는 라이브러리
  * spring-test  = 통합 테스트 지원






#웹뷰 만들기

main - resources - static - index.html  --> 스프링부트가 제공하는 welcome page

thymeleaf 엔진 사용

localhost:8080/hello -> helloController(model data:hello!)(return은 hello인데 return값과 똑같은 이름의 templates에서 hello파일을 찾는다 -> viewResolver(thymeleaf템플릿엔진) ->hello.html
  * 컨트롤러에서 리턴값으로 문자를 반환하면 templates에서 같은 파일을 찾는다
  * spring-boot-devtools 라이브러리를 추가하면 html파일만 컴파일하면 서버 재시작없이 변경가능 (build - Recompile)


#빌드 명령어

./gradlew build   -->  빌드
cd build/libs  --> 빌드된 파일이 있는곳
java -jar "빌드명"(hello-spring-0.0.1-SNAPSHOT.jar)  --> 서버 실행

./gradlew clean build --> 이전 빌드 지우고 빌드하기




#스프링 웹 개발 기초

1.정적 컨텐츠
2.MVC와 템플릿 엔진
3.API


1. 정적 컨텐츠  -> 컨트롤러에서 hello-static명을 찾는다. 없으면 static 폴더에서 hello-static을 찾아 반환해준다.
2. MVC와 템플릿 엔진 -> Model,view,controller 
                                localhost:8080/hello-mvc  -- > helloController에서 hello-mvc 찾기 
                                viewResolver가 templates/hello-tempate.html에서 반환(tymleaf 템플릿 엔진 처리)




3.API  
  @ResponseBody = 직접 데이터를 body에 주겠다
  helloController  -> @ResponseBody -> HttpMessageConverter(JsonConverter)(MappingJackson2HttpMessageConverter) -> 웹반환




##병원설계


#비지니스 요구사항 정리

 컨트롤러 : 웹 MVC의 컨트롤러
 서비스: 핵심 비즈니스 로직 구현
 리포지토리 : DB접근 , 도메인 객체를 DB 저장 관리
 도메인 : 비즈니스 도메인 객체 (회원,주문 DB에 저장하고 관리됨)




##스프링 빈 생성방법

1. 컴포넌트 스캔과 자동 의존관계 설정 
2. 자바 코드로 직접 스프링 빈 등록
 










