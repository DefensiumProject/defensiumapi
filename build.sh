#!/bin/bash

set -e

git reset --hard

mkdir -p ../defensiumlog

mvn clean install -DskipTests > ../defensiumlog/maven.log 2>&1

nohup java -jar target/defensium-service.jar > ../defensiumlog/application.log 2>&1 &

# tail -n 500 -f ../defensiumlog/application.log
