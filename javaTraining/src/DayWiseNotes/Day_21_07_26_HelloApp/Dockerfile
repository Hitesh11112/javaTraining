FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/HelloApp.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]