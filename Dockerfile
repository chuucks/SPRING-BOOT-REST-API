FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/employee-api-1.0.0.jar app.jar
#RUN apk update && apk add bash
EXPOSE 8080 5005
ENV _JAVA_OPTIONS '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
