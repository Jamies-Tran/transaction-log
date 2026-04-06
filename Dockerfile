FROM gradle:jdk-21-and-22-alpine AS build
WORKDIR /transaction-log
COPY settings.gradle ./
COPY build.gradle ./
COPY gradle ./
RUN gradle dependencies --no-daemon
COPY src ./src
RUN gradle build -x test --no-daemon

FROM eclipse-temurin:21-jre-alpine
COPY --from=build ./transaction-log/build/libs/*.jar transaction-log.jar
ENTRYPOINT ["java", "-jar", "transaction-log.jar"]