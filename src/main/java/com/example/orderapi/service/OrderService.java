package com.example.orderapi.service;

import com.example.orderapi.model.Item;
import com.example.orderapi.model.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String processOrder(OrderRequest request) {
        // Log the order details
        System.out.println("Processing Order:");
        System.out.println("Request ID: " + request.getRequestId());
        System.out.println("Order No: " + request.getOrderNo());
        System.out.println("Customer: " + request.getCustomerName());
        System.out.println("Items:");
        
        for (Item item : request.getItems()) {
            System.out.println("  - " + item.getItemDesc() + 
                             " (Qty: " + item.getItemQty() + ")");
        }
        
        // Add your business logic here
        // e.g., validate, save to database, call external services
        
        return "Order " + request.getOrderNo() + " processed successfully";
    }
}