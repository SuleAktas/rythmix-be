# FROM amazoncorretto:17
#
# ARG JAR_FILE=target/*.jar
#
# COPY ${JAR_FILE} application.jar
#
# CMD apt-get update -y
#
# ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]

FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/RythmixBE-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/RythmixBE-0.0.1-SNAPSHOT.jar"]



