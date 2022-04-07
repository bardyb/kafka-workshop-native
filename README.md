# Kafka - native Java

Build project
```sh
./gradlew clean build
```

Start Kafka broker
```sh
docker-compose up
```

Stop Kafka broker
```sh
docker-compose down
```

### Exercise #1
* Create a new topic via Kafka AdminClient with single partition
* Implement simple producer
* Implement simple consumer

### Exercise #2
* Create topic with 10 partitions
* Produce message with unique key, so they are distributed across all partitions

### Exercise #3
* Produce message in synchronous manner
* Test Producer Callback

### Reference
https://docs.confluent.io/clients-kafka-java/current/overview.html#java-installation
https://developer.confluent.io/tutorials/