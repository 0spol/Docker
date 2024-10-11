FROM openjdk:17-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /app

COPY ./src /app/src

CMD ["java", "src/Main.java"]
