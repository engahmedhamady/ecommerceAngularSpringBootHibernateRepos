package com.store.dal.entities;
// Generated Jan 27, 2021 1:34:35 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name="orders"
    ,catalog="ecommerce"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderId",
 scope =Orders.class)
public class Orders  implements java.io.Serializable {


     private Integer orderId;
     private Billingaddress billingaddress;
     private Customers customers;
     private Shipperaddress shipperaddress;
     private String orderTrackingNumber;
     private Integer totalPrice;
     private Integer totalQuantity;
     private String status;
     private Date dateCreated;
     private Date lastUpdate;
     private Set<Orderitems> orderitemses = new HashSet<Orderitems>(0);

    public Orders() {
    }

    public Orders(Billingaddress billingaddress, Customers customers, Shipperaddress shipperaddress, String orderTrackingNumber, Integer totalPrice, Integer totalQuantity, String status, Date dateCreated, Date lastUpdate, Set<Orderitems> orderitemses) {
       this.billingaddress = billingaddress;
       this.customers = customers;
       this.shipperaddress = shipperaddress;
       this.orderTrackingNumber = orderTrackingNumber;
       this.totalPrice = totalPrice;
       this.totalQuantity = totalQuantity;
       this.status = status;
       this.dateCreated = dateCreated;
       this.lastUpdate = lastUpdate;
       this.orderitemses = orderitemses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="orderID", unique=true, nullable=false)
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="billing_address_id")
    public Billingaddress getBillingaddress() {
        return this.billingaddress;
    }
    
    public void setBillingaddress(Billingaddress billingaddress) {
        this.billingaddress = billingaddress;
    }

@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    public Customers getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="shipper_address_id")
    public Shipperaddress getShipperaddress() {
        return this.shipperaddress;
    }
    
    public void setShipperaddress(Shipperaddress shipperaddress) {
        this.shipperaddress = shipperaddress;
    }

    
    @Column(name="order_tracking_number")
    public String getOrderTrackingNumber() {
        return this.orderTrackingNumber;
    }
    
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    
    @Column(name="total_price")
    public Integer getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    @Column(name="total_quantity")
    public Integer getTotalQuantity() {
        return this.totalQuantity;
    }
    
    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    
    @Column(name="status")
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp()
    @Column(name="date_created", length=19)
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name="last_update", length=19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="orders" , cascade = CascadeType.ALL)
    public Set<Orderitems> getOrderitemses() {
        return this.orderitemses;
    }
    
    public void setOrderitemses(Set<Orderitems> orderitemses) {
        this.orderitemses = orderitemses;
    }




}

