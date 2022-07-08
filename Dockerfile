FROM openjdk:8-jdk-alpine as base
RUN java -version

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src

FROM base as test
CMD ["./mvnw", "test"]

FROM base as build
RUN ./mvnw package


CMD ["./mvnw", "spring-boot:run"]