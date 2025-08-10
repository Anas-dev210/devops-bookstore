FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app/order-service
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/target/order-service*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]