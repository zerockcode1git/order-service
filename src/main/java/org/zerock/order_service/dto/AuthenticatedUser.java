package org.zerock.order_service.dto;

public record AuthenticatedUser(boolean authenticated, String userId, String userRole) {
  
}
