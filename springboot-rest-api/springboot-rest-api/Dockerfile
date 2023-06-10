FROM eclipse-temurin:17

LABEL mentainer="sophia.a@prodapt.com"

WORKDIR /app

COPY target/springboot-rest-api-0.0.1-SNAPSHOT.jar /app/springboot-rest-api.jar

ENTRYPOINT ["java", "-jar", "springboot-rest-api.jar"]