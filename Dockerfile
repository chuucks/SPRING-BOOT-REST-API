#FROM maven:3.6.1-amazoncorretto-8 as BUILD
#ADD m2.tar.gz /root
#COPY . /usr/src/app
#RUN mvn -Dmaven.repo.local=/root/m2 --batch-mode -f pom.xml clean package

FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/employee-api-1.0.0.jar app.jar
EXPOSE 8080 5005
ENV _JAVA_OPTIONS '-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
