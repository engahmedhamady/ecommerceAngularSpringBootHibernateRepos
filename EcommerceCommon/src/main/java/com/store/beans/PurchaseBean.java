
package com.store.beans;

import java.util.Set;

/**
 *
 * @author Sroor For Laptop
 */
public class PurchaseBean {
    private CustomersBean customersBean;
    private OrdersBean ordersBean;
    private  ShipperaddressBean shipperaddressBean;
    private BillingaddressBean billingaddressBean;
    private  Set<OrderitemsBean> orderitemsBeans;

    public CustomersBean getCustomersBean() {
        return customersBean;
    }

    public void setCustomersBean(CustomersBean customersBean) {
        this.customersBean = customersBean;
    }

    public OrdersBean getOrdersBean() {
        return ordersBean;
    }

    public void setOrdersBean(OrdersBean ordersBean) {
        this.ordersBean = ordersBean;
    }

    public ShipperaddressBean getShipperaddressBean() {
        return shipperaddressBean;
    }

    public void setShipperaddressBean(ShipperaddressBean shipperaddressBean) {
        this.shipperaddressBean = shipperaddressBean;
    }

    public BillingaddressBean getBillingaddressBean() {
        return billingaddressBean;
    }

    public void setBillingaddressBean(BillingaddressBean billingaddressBean) {
        this.billingaddressBean = billingaddressBean;
    }

    public Set<OrderitemsBean> getOrderitemsBeans() {
        return orderitemsBeans;
    }

    public void setOrderitemsBeans(Set<OrderitemsBean> orderitemsBeans) {
        this.orderitemsBeans = orderitemsBeans;
    }
    
    
}
