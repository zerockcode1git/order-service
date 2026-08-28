package org.zerock.order_service.event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class OrderCreatedEvent {

 private Long ono;
 private String userId;

 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
 private LocalDateTime orderedTime = LocalDateTime.now();

 private List<OrderedProduct> products = new ArrayList<>();

 public OrderCreatedEvent(Long ono, String userId) {
   this.ono = ono;
   this.userId = userId;
 }

 public void addProduct(Long pno, int qty) {
   products.add(new OrderedProduct(pno, qty));
 }

 @Getter
 @AllArgsConstructor
 @ToString
 public static class OrderedProduct {
   private Long pno;
   private int qty;
 }
}

