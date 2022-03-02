FROM openjdk:16-jdk-alpine
LABEL APPLICATION="Java Project"
WORKDIR /usr/app
COPY target/ecommerceapi-0.0.1-SNAPSHOT.jar ecommerceapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ecommerceapi-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

