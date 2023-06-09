# FROM eclipse-temurin:17
#
# LABEL mentainer="javaguides.net@gmail.com"
#
# WORKDIR /app
#
# COPY target/springboot-restful-webservices-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar
#
# ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]

FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package -DskipTests

FROM openjdk:8-alpine
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","app.jar"]