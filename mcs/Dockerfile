FROM openjdk:11-jre-slim

WORKDIR /app

RUN apt-get update && apt-get install

COPY target/mcs.jar /app

CMD ["java", "-jar", "mcs.jar"]
# This commented out ENTRYPOINT will start the container but not
# the python program. I have found this useful for debugging
# ENTRYPOINT ["tail", "-f", "/dev/null"]