mvn clean install -DskipTests &

mkdir ../defensiumlog &

nohup java -jar target/defensium-service.jar > ../defensiumlog/application.log 2>&1 &

tail -n 500 -f ../defensiumlog/application.log