FROM openjdk:22-slim as build

MAINTAINER chento_bank

COPY ./build/libs/card-0.0.1-SNAPSHOT.jar card-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar", "/card-0.0.1-SNAPSHOT.jar"]
