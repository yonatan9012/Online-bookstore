FROM eclipse-temurin:17-jre
COPY target/Online-bookstore*.jar /usr/src/Online-bookstore.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/Online-bookstore.jar", "--spring.config.location=file:/opt/conf/application.properties"]