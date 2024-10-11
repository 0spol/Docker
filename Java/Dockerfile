FROM openjdk:17-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /app

COPY ./src /app/src

RUN javac /app/src/Main.java

CMD ["java", "src/Main.java"]
