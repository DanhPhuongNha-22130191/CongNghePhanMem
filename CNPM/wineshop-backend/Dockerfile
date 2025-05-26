# Step 1: Build stage
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
# Copy chỉ pom.xml trước để cache dependencies
COPY pom.xml .
# Tải dependencies trước, tận dụng caching
RUN mvn dependency:go-offline -B
# Copy source code và build
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Thêm JVM options để tối ưu bộ nhớ và hiệu suất
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]