# Mock-Server Poc

Starts:

```sh
docker-compose up
mvn spring-boot:run
```

Urls:

| Service          | Url Spring Boot                             | Url Mock Server                             |
| ---------------- | ------------------------------------------- | ------------------------------------------- |
| Get Indices      | GET http://localhost:8080/broker/indices    | GET http://localhost:1080/broker/indices    |
| Get Portfolio    | GET http://localhost:8080/broker/portfolio  | GET http://localhost:8080/assets/portfolio  |
| Create Portfolio | POST http://localhost:8080/broker/portfolio | POST http://localhost:8080/assets/portfolio |
| Update Portfolio | PUT http://localhost:8080/broker/portfolio  | PUT http://localhost:8080/assets/portfolio  |

Postman Collection:

Testing-MockServer.postman_collection.json

Docs:

- [Doc](https://www.mock-server.com/#what-is-mockserver)
- [Config files](https://github.com/mock-server/mockserver/tree/master/helm/mockserver-config/static)
- [**Template Json**](https://www.mock-server.com/mock_server/creating_expectations.html#button_javascript_templated_response)
