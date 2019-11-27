FROM openjdk:8-jdk-alpine
ENV APP_FILE MyCustomerDemo-1.0.0-SNAPSHOT.jar
EXPOSE 8090
VOLUME /tmp
ARG JAR_FILE=target/*.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]