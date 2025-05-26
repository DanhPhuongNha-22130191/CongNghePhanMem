# Base image
FROM eclipse-temurin:17-jdk-alpine

# Tạo thư mục trong container
WORKDIR /app

# Copy file jar vào container
COPY target/*.jar app.jar

# Mở port 8080 (hoặc port bạn dùng)
EXPOSE 8080

# Lệnh chạy Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
