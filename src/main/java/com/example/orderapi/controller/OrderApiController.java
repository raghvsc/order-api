package com.example.orderapi.controller;

import com.example.orderapi.model.OrderRequest;
import com.example.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/health")
    public ResponseEntity<HealthResponse> healthCheck() {
        return ResponseEntity.ok(new HealthResponse(
            "UP",
            "Order API is running",
            LocalDateTime.now().toString()
        ));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        try {
            String message = orderService.processOrder(request);
            
            return ResponseEntity.ok(new OrderResponse(
                "SUCCESS",
                message,
                request.getOrderNo(),
                LocalDateTime.now().toString()
            ));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new OrderResponse(
                    "ERROR",
                    e.getMessage(),
                    null,
                    LocalDateTime.now().toString()
                ));
        }
    }

    // Response DTOs
    static class OrderResponse {
        private String status;
        private String message;
        private String orderNo;
        private String timestamp;

        public OrderResponse(String status, String message, String orderNo, String timestamp) {
            this.status = status;
            this.message = message;
            this.orderNo = orderNo;
            this.timestamp = timestamp;
        }

        public String getStatus() { return status; }
        public String getMessage() { return message; }
        public String getOrderNo() { return orderNo; }
        public String getTimestamp() { return timestamp; }
    }

    static class HealthResponse {
        private String status;
        private String message;
        private String timestamp;

        public HealthResponse(String status, String message, String timestamp) {
            this.status = status;
            this.message = message;
            this.timestamp = timestamp;
        }

        public String getStatus() { return status; }
        public String getMessage() { return message; }
        public String getTimestamp() { return timestamp; }
    }
}