package com.store.beans;
import java.util.HashSet;
import java.util.Set;

public class BillingaddressBean {


     private Integer billingId;
     private String country;
     private String state;
     private String city;
     private String street;
     private String zipCode;
     private Set<OrdersBean> orderses = new HashSet<OrdersBean>(0);

    public BillingaddressBean() {
    }

    public BillingaddressBean(String country, String state, String city, String street, String zipCode, Set<OrdersBean> orderses) {
       this.country = country;
       this.state = state;
       this.city = city;
       this.street = street;
       this.zipCode = zipCode;
       this.orderses = orderses;
    }
   
    
    public Integer getBillingId() {
        return this.billingId;
    }
    
    public void setBillingId(Integer billingId) {
        this.billingId = billingId;
    }

  
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }


    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    

    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    
    
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public Set<OrdersBean> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<OrdersBean> orderses) {
        this.orderses = orderses;
    }




}


