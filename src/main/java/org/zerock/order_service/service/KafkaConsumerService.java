package org.zerock.order_service.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaConsumerService {

 @KafkaListener(
         topics = "sample.created",
         groupId = "product-group-1")
 public void consume(
         @Payload String event,
         @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
         @Header(KafkaHeaders.OFFSET) long offset) {


   log.info("Received message: {}", event);
   log.info("수신: {} | partition={}, offset={}", event, partition, offset);
 }
}
