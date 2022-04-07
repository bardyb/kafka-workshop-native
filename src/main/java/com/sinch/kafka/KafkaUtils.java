package com.sinch.kafka;

import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;

public class KafkaUtils {

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
    var admin = AdminClient.create(configuration());
    var topic = new NewTopic(name, 1, (short) 1);
    admin.createTopics(List.of(topic));

    System.out.println("-- Topics: --");
    try {
      admin.listTopics().names().get().forEach(System.out::println);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
