package com.sinch.kafka;

import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Exercise1 {

  private static final String topic = "my-topic";

  public static void main(String[] args) {
    KafkaUtils.createTopic(topic);

    try (KafkaProducer<String, String> producer = new KafkaProducer(KafkaUtils.configuration())) {
      int counter = 0;

      while (counter <= 100) {
        String msg = "Message " + counter;

        ProducerRecord<String, String> message1 = new ProducerRecord<>(topic, msg);
        producer.send(message1);
        counter++;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
