FROM lpicanco/java11-alpine
ADD target/JpaSpielwiese-0.0.1-SNAPSHOT.jar /tmp/jpa-spielwiese.jar
ENV DB_JDBC_URL=jdbc:postgresql://meinedb:5432/league
ENV DB_USERNAME=richard
ENV DB_PASSWORD=test123
WORKDIR /tmp
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,address=8010,server=y,suspend=n"
ENTRYPOINT ["java", "-jar", "/tmp/jpa-spielwiese.jar"]
