echo 'stopping docker containers';
docker stop adjusters-db;
docker stop loss-notification-db;
docker stop loss-management-db;
docker stop rabbitmq-loss;
echo 'docker containers stopped';

echo 'stopping consul';
consul leave;
echo 'consul stopped';

echo 'stopping microservices';
lsof -ti tcp:8080 | xargs kill;
lsof -ti tcp:8081 | xargs kill;
lsof -ti tcp:8082 | xargs kill;
lsof -ti tcp:8083 | xargs kill;
lsof -ti tcp:8084 | xargs kill;
lsof -ti tcp:8085 | xargs kill;
echo 'microservices stopped';
