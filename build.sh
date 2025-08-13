#!/bin/bash
set -e

git reset --hard

nohup mvn clean install package -DskipTests > ../defensiumlog/maven.log 2>&1 &

mkdir -p ../defensiumlog

pkill -f "java -jar $JAR_PATH" || true

nohup java -jar target/defensium-service.jar > ../defensiumlog/application.log 2>&1 &

sleep 5

tail -n 500 -f ../defensiumlog/application.log
