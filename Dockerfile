FROM openjdk:17 AS builder
COPY ./build/libs/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]