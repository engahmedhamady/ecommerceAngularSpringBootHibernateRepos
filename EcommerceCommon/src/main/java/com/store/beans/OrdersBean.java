package com.store.beans;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class OrdersBean {


     private Integer orderId;
     private BillingaddressBean billingaddressBean;
     private CustomersBean customersBean;
     private ShipperaddressBean shipperaddressBean;
     private String orderTrackingNumber;
     private Integer totalPrice;
     private Integer totalQuantity;
     private String status;
     private Date dateCreated;
     private Date lastUpdate;
     private Set<OrderitemsBean> orderitemsesBeans = new HashSet<OrderitemsBean>(0);

    public OrdersBean() {
    }

    public OrdersBean(BillingaddressBean billingaddressBean, CustomersBean customersBean, ShipperaddressBean shipperaddressBean, String orderTrackingNumber, Integer totalPrice, Integer totalQuantity, String status, Date dateCreated, Date lastUpdate, Set<OrderitemsBean> orderitemsesBeans) {
       this.billingaddressBean = billingaddressBean;
       this.customersBean = customersBean;
       this.shipperaddressBean = shipperaddressBean;
       this.orderTrackingNumber = orderTrackingNumber;
       this.totalPrice = totalPrice;
       this.totalQuantity = totalQuantity;
       this.status = status;
       this.dateCreated = dateCreated;
       this.lastUpdate = lastUpdate;
       this.orderitemsesBeans = orderitemsesBeans;
    }
   

    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public BillingaddressBean getBillingaddressBean() {
        return this.billingaddressBean;
    }
    
    public void setBillingaddressBean(BillingaddressBean billingaddressBean) {
        this.billingaddressBean = billingaddressBean;
    }


    public CustomersBean getCustomersBean() {
        return this.customersBean;
    }
    
    public void setCustomers(CustomersBean customersBean) {
        this.customersBean = customersBean;
    }


    public ShipperaddressBean getShipperaddressBean() {
        return this.shipperaddressBean;
    }
    
    public void setShipperaddressBean(ShipperaddressBean shipperaddressBean) {
        this.shipperaddressBean = shipperaddressBean;
    }

   
    public String getOrderTrackingNumber() {
        return this.orderTrackingNumber;
    }
    
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    

    public Integer getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    

    public Integer getTotalQuantity() {
        return this.totalQuantity;
    }
    
    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    
  
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

  
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public Set<OrderitemsBean> getOrderitemsesBeans() {
        return this.orderitemsesBeans;
    }
    
    public void setOrderitemsesBean(Set<OrderitemsBean> orderitemsesBeans) {
        this.orderitemsesBeans = orderitemsesBeans;
    }




}


