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







