# Starting with a base Image containing Java Runtime :-
FROM openjdk:21-jdk-slim

# Information around who maintains the image
LABEL maintainer="Abhishek@gmail.com"

# Add the applications jar to the image.
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

