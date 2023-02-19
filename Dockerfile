FROM openjdk:18
ADD ./covid-tracker.jar covid-tracker.jar
ENTRYPOINT ["java","-jar","covid-tracker.jar"]