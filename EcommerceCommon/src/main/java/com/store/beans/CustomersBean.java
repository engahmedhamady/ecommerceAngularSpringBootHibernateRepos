package com.store.beans;


import java.util.HashSet;
import java.util.Set;


public class CustomersBean {


     private Integer customerId;
     private String fname;
     private String lname;
     private String email;
     
     private Set<OrdersBean> orderses = new HashSet<OrdersBean>(0);

    public CustomersBean() {
    }

    public CustomersBean(String fname, String lname, String email,Set<OrdersBean> orderses) {
       this.fname = fname;
       this.lname = lname;
       this.email = email;
    
       this.orderses = orderses;
    }
   

    public Integer getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }

    

    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }

    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
 

    public Set<OrdersBean> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<OrdersBean> orderses) {
        this.orderses = orderses;
    }




}


