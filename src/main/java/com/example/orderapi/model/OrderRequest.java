package com.example.orderapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class OrderRequest {
    
    @JsonProperty("RequestId")
    private String requestId;
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("CustomerName")
    private String customerName;
    
    @JsonProperty("Item")
    private List<Item> items;

    public OrderRequest() {}

    public OrderRequest(String requestId, String orderNo, String customerName, List<Item> items) {
        this.requestId = requestId;
        this.orderNo = orderNo;
        this.customerName = customerName;
        this.items = items;
    }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    @Override
    public String toString() {
        return "OrderRequest{requestId='" + requestId + "', orderNo='" + orderNo + 
               "', customerName='" + customerName + "', items=" + items + "}";
    }
}