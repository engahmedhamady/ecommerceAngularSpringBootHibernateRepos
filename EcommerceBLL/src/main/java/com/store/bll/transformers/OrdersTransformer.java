package com.store.bll.transformers;

import com.store.beans.BillingaddressBean;
import com.store.beans.CustomersBean;
import com.store.beans.OrderitemsBean;
import com.store.beans.OrdersBean;
import com.store.beans.ProductsBean;
import com.store.beans.ShipperaddressBean;
import com.store.dal.entities.Billingaddress;
import com.store.dal.entities.Customers;
import com.store.dal.entities.Orderitems;
import com.store.dal.entities.Orders;
import com.store.dal.entities.Products;
import com.store.dal.entities.Shipperaddress;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value = "ordersTransformer")
public class OrdersTransformer {

    public OrdersBean transformEntityToBean(Orders entity) {
        if (entity == null) {
            return null;
        }
        OrdersBean bean = new OrdersBean();

        // transform
        BillingaddressBean billingaddressBean = new BillingaddressBean();;
        billingaddressBean.setBillingId(entity.getBillingaddress().getBillingId());
        billingaddressBean.setCity(entity.getBillingaddress().getCity());
        billingaddressBean.setCountry(entity.getBillingaddress().getCountry());
        billingaddressBean.setState(entity.getBillingaddress().getState());
        billingaddressBean.setStreet(entity.getBillingaddress().getStreet());
        billingaddressBean.setZipCode(entity.getBillingaddress().getZipCode());
        bean.setBillingaddressBean(billingaddressBean);

        CustomersBean customersBean = new CustomersBean();
        customersBean.setCustomerId(entity.getCustomers().getCustomerId());
        customersBean.setEmail(entity.getCustomers().getEmail());
        customersBean.setFname(entity.getCustomers().getFname());
        customersBean.setLname(entity.getCustomers().getLname());
        bean.setCustomers(customersBean);

        bean.setDateCreated(entity.getDateCreated());
        bean.setLastUpdate(entity.getLastUpdate());
        bean.setOrderId(entity.getOrderId());
        bean.setOrderTrackingNumber(entity.getOrderTrackingNumber());
        bean.setStatus(entity.getStatus());
        bean.setTotalPrice(entity.getTotalPrice());
        bean.setTotalQuantity(entity.getTotalQuantity());

        Set<OrderitemsBean> set = new HashSet<>();

        for (Orderitems orderitems : entity.getOrderitemses()) {
            OrderitemsBean orderitemsBean = new OrderitemsBean();
            //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
            orderitemsBean.setOrderItemId(orderitems.getOrderItemId());
            orderitemsBean.setImageUrl(orderitems.getProducts().getImageUrl());
            orderitemsBean.setQuantity(orderitems.getQuantity());
            orderitemsBean.setUnitPrice(orderitems.getUnitPrice());
             ProductsBean productsBean = new ProductsBean();
            productsBean.setProductId(orderitems.getProducts().getProductId());
            orderitemsBean.setProducts(productsBean);                   
            OrdersBean o = new OrdersBean();
            o.setOrderId(orderitems.getOrders().getOrderId());
            orderitemsBean.setOrders(o);
            set.add(orderitemsBean);
        }
        bean.setOrderitemsesBean(set);

        ShipperaddressBean shipperaddressBean = new ShipperaddressBean();
        shipperaddressBean.setShipperId(entity.getShipperaddress().getShipperId());
        shipperaddressBean.setCity(entity.getShipperaddress().getCity());
        shipperaddressBean.setCountry(entity.getShipperaddress().getCountry());
        shipperaddressBean.setState(entity.getShipperaddress().getState());
        shipperaddressBean.setStreet(entity.getShipperaddress().getStreet());
        shipperaddressBean.setZipCode(entity.getShipperaddress().getZipCode());
        bean.setShipperaddressBean(shipperaddressBean);

        return bean;
    }

    public Orders transformBeanToEntity(OrdersBean bean) {
        if (bean == null) {
            return null;
        }
        Orders entity = new Orders();
        
        Billingaddress billingaddress = new Billingaddress();
        billingaddress.setBillingId(bean.getBillingaddressBean().getBillingId());
        billingaddress.setCity(bean.getBillingaddressBean().getCity());
        billingaddress.setCountry(bean.getBillingaddressBean().getCountry());
        billingaddress.setState(bean.getBillingaddressBean().getState());
        billingaddress.setStreet(bean.getBillingaddressBean().getStreet());
        billingaddress.setZipCode(bean.getBillingaddressBean().getZipCode());
        entity.setBillingaddress(billingaddress);

        Customers customers = new Customers();
        customers.setCustomerId(bean.getCustomersBean().getCustomerId());
        customers.setEmail(bean.getCustomersBean().getEmail());
        customers.setFname(bean.getCustomersBean().getFname());
        customers.setLname(bean.getCustomersBean().getLname());
        entity.setCustomers(customers);

        entity.setDateCreated(bean.getDateCreated());
        entity.setLastUpdate(bean.getLastUpdate());
        entity.setOrderId(bean.getOrderId());
        entity.setOrderTrackingNumber(bean.getOrderTrackingNumber());
        entity.setStatus(bean.getStatus());
        entity.setTotalPrice(bean.getTotalPrice());
        entity.setTotalQuantity(bean.getTotalQuantity());

        Set<Orderitems> set = new HashSet<>();

        for (OrderitemsBean orderitemsBean : bean.getOrderitemsesBeans()) {
            Orderitems orderitems = new Orderitems();
            //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
            orderitems.setOrderItemId(orderitemsBean.getOrderItemId());
            orderitems.setImageUrl(orderitemsBean.getProducts().getImageUrl());
            orderitems.setQuantity(orderitemsBean.getQuantity());
            orderitems.setUnitPrice(orderitemsBean.getUnitPrice());
            Products products = new Products();
            products.setProductId(orderitemsBean.getProducts().getProductId());
            orderitems.setProducts(products);                   
            Orders o = new Orders();
            o.setOrderId(orderitemsBean.getOrders().getOrderId());
            orderitems.setOrders(o);
            set.add(orderitems);
        }
        entity.setOrderitemses(set);

        Shipperaddress shipperaddress = new Shipperaddress();
        shipperaddress.setShipperId(bean.getShipperaddressBean().getShipperId());
        shipperaddress.setCity(bean.getShipperaddressBean().getCity());
        shipperaddress.setCountry(bean.getShipperaddressBean().getCountry());
        shipperaddress.setState(bean.getShipperaddressBean().getState());
        shipperaddress.setStreet(bean.getShipperaddressBean().getStreet());
        shipperaddress.setZipCode(bean.getShipperaddressBean().getZipCode());

        entity.setShipperaddress(shipperaddress);
        
        
        return entity;
    }
}
