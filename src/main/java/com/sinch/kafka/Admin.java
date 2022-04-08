package com.sinch.kafka;

public class Admin {

  public static void main(String[] args) {
    KafkaUtils.createTopic(KafkaUtils.TOPIC);
    KafkaUtils.listTopics();
  }

}
