# Stage 1: Build using Maven and Temurin JDK
FROM maven:3.8.4-eclipse-temurin-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package

# Stage 2: Runtime using lightweight Temurin JRE
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /app/target/student-app-1.0-SNAPSHOT.jar student-app.jar
ENTRYPOINT ["java", "-jar", "/student-app.jar"]