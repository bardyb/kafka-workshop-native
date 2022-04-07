package com.sinch.kafka;

import java.util.Properties;

public class KafkaUtils {

  public static final String TOPIC = "my-topic";

  public static Properties configuration() {
    var props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//    props.put("group.id", "test-group");
    return props;
  }

  public static void createTopic(String name) {
  }
}
