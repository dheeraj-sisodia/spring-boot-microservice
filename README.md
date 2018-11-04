Service URLs

http://localhost:8000/user/userId/USR1

http://localhost:8200/order/orderId/ORD1

http://localhost:8200/order/userId/USR1

http://localhost:8765/user-service/user/userId/USR1

http://localhost:8765/order-service/order/orderId/ORD1

http://localhost:8765/order-service/order/userId/USR1

http://localhost:8081/spring-security-oauth-server/oauth/token


sudo service cassandra start

sudo service cassandra stop

nodetool status

CREATE KEYSPACE IF NOT EXISTS sample WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

DESCRIBE keyspaces;

use sample;

CREATE TABLE customer (id UUID PRIMARY KEY, firstname text, lastname text);



