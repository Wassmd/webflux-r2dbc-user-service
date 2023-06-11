# webflux-r2dbc-user-service

### Run the project
1. ./gradlew clean build (This cleans, build and tests)
2. docker build -t user-service . (build docker image)
3. docker run -p 8083:8083 user-service
