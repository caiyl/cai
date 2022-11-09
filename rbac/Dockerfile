# 指定基础镜像，这是分阶段构建的前期阶段
FROM openjdk:8-jdk-alpine as builder
ADD ./target/rbac-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
