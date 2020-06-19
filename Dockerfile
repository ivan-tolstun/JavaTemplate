FROM openjdk:14-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=build
RUN echo ${DEPENDENCY}
COPY ${DEPENDENCY}/libs/*.jar /app/lib/demo.jar
ENTRYPOINT ["java", "--enable-preview", "-jar", "/app/lib/demo.jar"]