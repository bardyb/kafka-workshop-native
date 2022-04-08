package com.sinch.kafka;

import static java.util.Collections.singleton;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListPartitionReassignmentsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaUtils {

  public static final String TOPIC = "my-topic-3";

  public static Properties configuration() {
    var props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("group.id", "test-group1");
    return props;
  }

  public static void createTopic(String name) {
    AdminClient adminClient = AdminClient.create(configuration());
    adminClient.createTopics(singleton(new NewTopic(name, 10, (short) 1)));
    try {
      adminClient.listTopics().names().get().forEach(System.out::println);
      adminClient.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void listTopics() {
    AdminClient adminClient = AdminClient.create(configuration());
    System.out.println("-- Topics: --");
    try {
      adminClient.listTopics().names().get().forEach(System.out::println);
      System.out.println(adminClient.listPartitionReassignments());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static KafkaProducer<String, String> createProducer() {
    return new KafkaProducer<>(configuration());
  }

  public static KafkaConsumer<String, String> createConsumer() {
    return new KafkaConsumer<>(configuration());
  }
}
