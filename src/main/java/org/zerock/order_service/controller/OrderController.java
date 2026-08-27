package org.zerock.order_service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.zerock.order_service.service.KafkaProducerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrderController {

 private final KafkaProducerService kafkaProducerService;

 @GetMapping("hello")
 public String[] hello() {
     return new String[]{"Hello", "Order", "Service"};
 }

 @GetMapping("sendMsg")
 public String sendMsg() {

   String message = "Hello, Kafka! " + System.currentTimeMillis();

   kafkaProducerService.sendMessage(message);

   return "Message sent!";
 }
}
