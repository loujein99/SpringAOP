#FROM maven:3.8.2-jdk-8
#
#WORKDIR /spring-app
#COPY . .
#RUN mvn clean install
#
#CMD mvn spring-boot:run
FROM openjdk:11
ADD target/tpAchatProject-1.0.jar tpachatproject.jar
ENTRYPOINT ["java","-jar","/tpachatproject.jar"]