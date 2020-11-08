echo 'running postgres instances and rabbit';
docker-compose up -d;
echo 'databases and rabbit are ready';

echo 'starting consul';
consulPackageName='consul';
if ! dpkg -s $consulPackageName >/dev/null 2>&1; then
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -;
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main";
sudo apt-get update && sudo apt-get install consul;
fi
consul agent -dev &
echo 'consul started on default port which is 8500';

echo 'starting microservices';
(cd loss-config-service && mvn spring-boot:run &) 
(cd loss-tracing-service && mvn spring-boot:run &) 
(cd loss-adjusters-service && mvn spring-boot:run &) 
(cd loss-management-service && mvn spring-boot:run &) 
(cd loss-notification-service && mvn spring-boot:run &) 
(cd loss-api-gateway-service && mvn spring-boot:run &) 
echo 'microservices started';

