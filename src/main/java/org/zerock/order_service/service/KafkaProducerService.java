package org.zerock.order_service.service;


import org.springframework.stereotype.Service;
import org.zerock.order_service.event.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@RequiredArgsConstructor
@Log4j2
public class KafkaProducerService {

 //의존성 주입
 private final KafkaTemplate<String, Object> kafkaTemplate;

 public void sendMessage(String message) {

   //sample.created 토픽으로 메시지 전송
  
   kafkaTemplate
   .send("sample.created", message)
   .whenComplete( (result,ex) -> {
       if(ex != null) {
           log.error("Failed to send message: " + ex.getMessage());
       } else {
           log.info("Message sent successfully: " + message);
       }
   });
 }

  public void sendOrderCreatedEvent(OrderCreatedEvent event) {
   kafkaTemplate
   .send("order.created", event)
   .whenComplete((result, ex) -> {
       if (ex != null) {
           log.error("Failed to send OrderCreatedEvent: " + ex.getMessage());
       } else {
           log.info("OrderCreatedEvent sent successfully: " + event);
       }
   });
  }


}
