FROM openjdk:17-jdk-slim

MAINTAINER paxier.com

COPY  build/libs/user-service.jar user-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/user-service.jar"]
