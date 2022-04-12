
# Getting Started
Don't forget to set up elasticsearch and kibana, optionally.

Checking elasticsearch: 
http://localhost:9200/_cat/indices

Kibana console: 
http://localhost:5601/app/dev_tools#/console

Postman collection in resources.

### Useful Elastic Search Queries
```
GET employee/_search

GET employee/_search
{ 
  "query": {
    "match": {
      "_id": "99oxH4ABT2YLt1RYy4VH"
    }
  }
}

POST employee/_update/99oxH4ABT2YLt1RYy4VH
{
  "doc": {
    "name": "NewName1"
  }
}


POST employee/_update/99oxH4ABT2YLt1RYy4VH
{
  "doc": {
    "address": {
      "city": "NewName1"
    }
  }
}

```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

