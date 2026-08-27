package org.zerock.order_service.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Log4j2
public class OrderController {

 @GetMapping("hello")
 public String[] hello() {
     return new String[]{"Hello", "Order", "Service"};
 }
}
