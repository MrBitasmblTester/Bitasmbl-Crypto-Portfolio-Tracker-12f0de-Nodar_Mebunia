FROM eclipse-temurin:17-jdk
COPY . /app
WORKDIR /app
RUN ./gradlew shadowJar --no-daemon
CMD ["java","-jar","build/libs/crypto-tracker-all.jar"]
