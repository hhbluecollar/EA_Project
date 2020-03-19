FROM openjdk:8
ADD target/docker-spring-bootv4.jar   docker-spring-bootv4.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-spring-bootv4.jar"]


