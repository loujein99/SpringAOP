FROM openjdk:11-jre-slim
EXPOSE 8089
ADD target/tpAchatProject-1.0.jar tpachatproject-1.0.jar
ENTRYPOINT ["java","-jar","/tpachatproject.jar"]
