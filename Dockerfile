FROM openjdk:22-jdk-slim

WORKDIR /lab3

COPY pom.xml .
COPY src ./src

COPY target/lab3-1.0-SNAPSHOT.jar lab3.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "lab3.jar"]
