# 指定基础镜像，这是分阶段构建的前期阶段
FROM openjdk:8-jdk-alpine as builder

ADD ./target/cai.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
