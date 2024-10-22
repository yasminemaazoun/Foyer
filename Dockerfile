FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/tp-foyer-5.0.0.jar td-foyer-5.0.0.jar
ENTRYPOINT ["java","-jar","/td-foyer-5.0.0gi.jar"]
