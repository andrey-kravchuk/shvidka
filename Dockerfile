FROM maven:3.6.0-jdk-8-alpine

COPY . /app

WORKDIR /app

CMD ["mvn", "spring-boot:run"]