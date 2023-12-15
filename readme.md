## Development

Start the compose project with: 
```
docker compose up -d --build
``

To list containers:
```
docker ps
``

Containers should look as follows:

```
CONTAINER ID   IMAGE             COMMAND                  CREATED       STATUS         PORTS                    NAMES
269f36645490   mcs:image         "java -jar mcs.jar"      2 hours ago   Up 5 seconds   0.0.0.0:8082->8082/tcp   turion-mcs-1
a794f35adbc4   sat:image         "java -jar sat.jar"      2 hours ago   Up 5 seconds   0.0.0.0:8083->8083/tcp   turion-sat-1
2400601d0378   clientapi:image   "java -jar clientapi…"   2 hours ago   Up 6 seconds   0.0.0.0:8081->8081/tcp   turion-client-api-1
446f3e8ec6ca   postgres:latest   "docker-entrypoint.s…"   2 hours ago   Up 6 seconds   0.0.0.0:5431->5432/tcp   turion-postgres-1
``



