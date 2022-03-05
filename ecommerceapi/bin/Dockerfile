FROM maven:3.5-jdk-8 AS build  
COPY src /usr/app/src  
COPY pom.xml /usr/app  
RUN mvn -f /usr/app/pom.xml clean package

FROM gcr.io/distroless/java  
COPY --from=build /usr/app/target/ecommerceapi-0.0.1-SNAPSHOT.jar /usr/app/ecommerceapi-0.0.1-SNAPSHOT.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/ecommerceapi-0.0.1-SNAPSHOT.jar"]  

