package com.sinch.kafka;

import java.util.List;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Exercise2 {

  private static final String topic = "my-topic";

  public static void main(String[] args) {

    var kafkaConsumer = new KafkaConsumer<String, String>(KafkaUtils.configuration());
    kafkaConsumer.subscribe(List.of(topic));

    System.out.println("Start");
    try{
      while (true){
        var records = kafkaConsumer.poll(10);
        for (ConsumerRecord record: records){
          System.out.println(String.format("Topic - %s, Partition - %d, Value: %s", record.topic(), record.partition(), record.value()));
        }
      }
    }catch (Exception e){
      System.out.println(e.getMessage());
    }finally {
      kafkaConsumer.close();
    }


  }
}
