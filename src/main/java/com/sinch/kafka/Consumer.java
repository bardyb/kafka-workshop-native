package com.sinch.kafka;

import java.time.Duration;
import java.util.Collections;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords ;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Consumer {

  public static void main(String[] args) {
    try (KafkaConsumer<String, String> consumer = KafkaUtils.createConsumer()) {
      consumer.subscribe(Collections.singleton(KafkaUtils.TOPIC));
      System.out.println("Subscribed to the Topic");
      while (true) {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
        for (ConsumerRecord<String, String> record : records) {
          System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(),
              record.value());
        }
      }
    }
  }
}
