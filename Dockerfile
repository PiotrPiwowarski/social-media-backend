FROM openjdk:17-jdk
COPY target/social-media-backend.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/social-media-backend.jar"]