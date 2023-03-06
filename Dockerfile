FROM amazoncorretto:8-alpine-jdk
MAINTAINER Oscar
COPY /target/Oscar-0.0.1-SNAPSHOT.jar Oscar-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Oscar-0.0.1-SNAPSHOT.jar"]
