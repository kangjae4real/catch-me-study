#!/usr/bin/env bash

# Please do not add "remove '.da_data' directory" code
# If you remove the ".db_data" directory, all DB data is removed.

docker compose down -v # All container down
docker system prune -a -f # Remove all existing container and volume
git pull origin master # Pulling code
docker compose up -d
./gradlew clean # Clean-up existing build result
./gradlew build # Build project
java -jar ./build/libs/catch-me-study-0.0.1-SNAPSHOT.jar