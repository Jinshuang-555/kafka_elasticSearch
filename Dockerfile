# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

ENV DEBUG=true

# Copy the JAR file to the container

COPY target/kafka_elasticSearch-0.0.1-SNAPSHOT.jar /app/

WORKDIR /app

ENV SPRING_DATA_ELASTICSEARCH_CLUSTER_NODES=elasticsearch:9300
ENV SPRING_ELASTICSEARCH_URIS=http://elasticsearch:9200

# Expose port for Spring Boot application
EXPOSE 8082

# Run the Spring Boot application
CMD ["java", "-jar", "kafka_elasticSearch-0.0.1-SNAPSHOT.jar"]