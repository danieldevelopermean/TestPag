FROM java:8
EXPOSE 8082
COPY /target/TestPag-0.0.1-SNAPSHOT.jar back.jar
ENTRYPOINT ["java","-jar","back.jar"]