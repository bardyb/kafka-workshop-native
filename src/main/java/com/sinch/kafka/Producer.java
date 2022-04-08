package com.sinch.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {

  public static void main(String[] args) {
    KafkaProducer<String, String> producer = KafkaUtils.createProducer();

    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "1Key", "Value"));
    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "K1ey2", "Value"));
    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "Key3", "Value"));
    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "Ke1y4", "Value"));
    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "Key15", "Value"));
    producer.send(new ProducerRecord<>(KafkaUtils.TOPIC, "Key61", "Value"));

    producer.close();
  }
}
