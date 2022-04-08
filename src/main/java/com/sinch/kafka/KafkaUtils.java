package com.sinch.kafka;

import static java.util.Collections.singleton;

import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaUtils {

  public static final String TOPIC = "my-topic";
  public static final String BOOTSTRAP_SERVER = "localhost:9092";

  public static Properties configuration() {
    var props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("group.id", "test-group");
    return props;
  }

  public static void createTopic(String name) {
    AdminClient adminClient = AdminClient.create(configuration());
    adminClient.createTopics(singleton(new NewTopic(name, 1, (short) 1)));
  }

  public static KafkaProducer<String, String> createProducer() {
    return new KafkaProducer<>(configuration());
  }

  public static KafkaConsumer<String, String> createConsumer() {
    return new KafkaConsumer<>(configuration());
  }
}
