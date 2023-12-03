FROM openjdk:8-jdk-alpine
MAINTAINER kboduroglu
COPY target/earthquakes-0.3.jar quakes-app-0.3.jar
ENTRYPOINT ["java","-jar","/quakes-app-0.3.jar"]