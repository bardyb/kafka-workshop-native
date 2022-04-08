package com.sinch.kafka;

import java.util.UUID;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

  public static void main(String[] args) {
    try (KafkaProducer<String, String> producer = KafkaUtils.createProducer()) {
      int counter = 0;
      while (counter <= 100) {
        producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, UUID.randomUUID().toString(), "Value" + counter++));
      }
    }
  }
}
