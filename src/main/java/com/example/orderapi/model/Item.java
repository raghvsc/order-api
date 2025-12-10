package com.example.orderapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    
    @JsonProperty("ItemNo")
    private String itemNo;
    
    @JsonProperty("ItemDesc")
    private String itemDesc;
    
    @JsonProperty("ItemQty")
    private int itemQty;

    public Item() {}

    public Item(String itemNo, String itemDesc, int itemQty) {
        this.itemNo = itemNo;
        this.itemDesc = itemDesc;
        this.itemQty = itemQty;
    }

    public String getItemNo() { return itemNo; }
    public void setItemNo(String itemNo) { this.itemNo = itemNo; }

    public String getItemDesc() { return itemDesc; }
    public void setItemDesc(String itemDesc) { this.itemDesc = itemDesc; }

    public int getItemQty() { return itemQty; }
    public void setItemQty(int itemQty) { this.itemQty = itemQty; }

    @Override
    public String toString() {
        return "Item{itemNo='" + itemNo + "', itemDesc='" + itemDesc + 
               "', itemQty=" + itemQty + "}";
    }
}