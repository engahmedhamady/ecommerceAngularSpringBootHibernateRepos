package com.store.beans;

public class OrderitemsBean  implements java.io.Serializable {


     private Integer orderItemId;
     private OrdersBean orders;
     private ProductsBean products;
     private Integer unitPrice;
     private Integer quantity;
     private String imageUrl;

    public OrderitemsBean() {
    }
public OrderitemsBean(Integer orderItemId) {
    this.orderItemId=orderItemId;
    }

    public OrderitemsBean(OrdersBean orders, ProductsBean products, Integer unitPrice, Integer quantity, String imageUrl) {
       this.orders = orders;
       this.products = products;
       this.unitPrice = unitPrice;
       this.quantity = quantity;
       this.imageUrl = imageUrl;
    }
   
    
    public Integer getOrderItemId() {
        return this.orderItemId;
    }
    
    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }


    public OrdersBean getOrders() {
        return this.orders;
    }
    
    public void setOrders(OrdersBean orders) {
        this.orders = orders;
    }


    public ProductsBean getProducts() {
        return this.products;
    }
    
    public void setProducts(ProductsBean products) {
        this.products = products;
    }

    
    public Integer getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    

    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    public String getImageUrl() {
        return this.imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }




}


