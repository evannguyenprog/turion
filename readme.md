## Development

Start the compose project with: 
```
docker compose up -d --build
```

To list containers:
```
docker ps
```

Containers should look as follows:

```
CONTAINER ID   IMAGE             COMMAND                  CREATED       STATUS         PORTS                    NAMES
269f36645490   mcs:image         "java -jar mcs.jar"      2 hours ago   Up 5 seconds   0.0.0.0:8082->8082/tcp   turion-mcs-1
a794f35adbc4   sat:image         "java -jar sat.jar"      2 hours ago   Up 5 seconds   0.0.0.0:8083->8083/tcp   turion-sat-1
2400601d0378   clientapi:image   "java -jar clientapi…"   2 hours ago   Up 6 seconds   0.0.0.0:8081->8081/tcp   turion-client-api-1
446f3e8ec6ca   postgres:latest   "docker-entrypoint.s…"   2 hours ago   Up 6 seconds   0.0.0.0:5431->5432/tcp   turion-postgres-1
```

- Satellite Service runs on port 8083

- MCS runs on port 8082

- ClientApi runs on port 8081

- Postgres db runs on port 5432

## API EndPoints
Import the turion.postman_collection.json into Postman
Contains the endpoints:
```
POST localhost:8081/satellites  | create new satellite  | body of satellite name
POST localhost:8081/image-request  | create imageRequest for satellite | body of satelliteId
GET localhost:8081/get-images/{id}  | get all images of satellite  | satelliteid passed as param
GET localhost:8081/image-request/all  | return all imageRequests  | for visualization
```

## DB Schema
For db schema, refer to the scripts within the sql directory

satellite, image_request, and image tables

## Notes

MCS executes every 30 seconds to simulate the intermittent messaging between the satellite and station
Executes based off image requests within db, while also downloading all images in satellite local cache