FROM docker.io/library/maven:3.9-eclipse-temurin-17 AS build
WORKDIR /src
COPY pom.xml .
COPY src ./src
RUN mvn -q -B package dependency:copy-dependencies -DoutputDirectory=target/lib

FROM docker.io/library/eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /src/target/super-secure-java-app-1.0.0.jar app.jar
COPY --from=build /src/target/lib ./lib
CMD ["java", "-cp", "app.jar:lib/*", "com.example.supersecure.App"]
