FROM openjdk:8-jre-alpine
MAINTAINER devopsbootcamp team
RUN apk update
RUN apk add curl
      
COPY ./target/DevOpsCampAPI-0.0.1-SNAPSHOT.jar /

COPY test.sh /
RUN chmod +x /test.sh

# Default command for image
ENTRYPOINT ["/usr/bin/java", "-jar", "/DevOpsCampAPI-0.0.1-SNAPSHOT.jar"]
CMD ["-port", "8080"]
