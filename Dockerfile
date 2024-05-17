FROM bellsoft/liberica-openjdk-alpine:22.0.1-cds

RUN apk add curl jq

WORKDIR /home/DockerFramework

ADD target/docker-resources .

ENTRYPOINT java -cp "libs/*" org.testng.TestNG test-suites/flight-reservation.xml