FROM openjdk:21-bullseye AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn/ .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests


FROM openjdk:21-bullseye

WORKDIR /app

COPY --from=build /app/target/*.jar /app/user-service.jar

EXPOSE 8006

ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]