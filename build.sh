#!/bin/bash

set -e

git reset --hard

mkdir -p ../defensiumlog

mvn clean install -DskipTests

nohup java -jar target/defensium-service.jar > ../defensiumlog/application.log 2>&1 &

sleep 5

tail -n 500 -f ../defensiumlog/application.log
