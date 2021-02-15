package com.store.controllers;

import com.store.beans.OrdersBean;
import com.store.bll.delegate.StoreGetWay;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchase")
@CrossOrigin("http://localhost:4200")
public class OrdersController {

    @Autowired
    private StoreGetWay storeGetway = null;
OrdersBean o= new OrdersBean();
    @GetMapping(value = "/allPurchase")
    public List<OrdersBean> getPurchase() {
        List<OrdersBean> listProductsByCategory = storeGetway.listAllOrders();

        return listProductsByCategory;
    }

    @PostMapping(value = "/addpurchase")
    public OrdersBean AddPurchase(@RequestBody OrdersBean ordersBean) {
        System.out.println(ordersBean.getOrderId());
        System.out.println(ordersBean.getTotalPrice());
        System.out.println(ordersBean.getTotalQuantity());
        System.out.println(ordersBean.getCustomersBean().getFname());
        System.out.println(ordersBean.getLastUpdate());
       

        OrdersBean bean = storeGetway.addPurchase(ordersBean);

        return bean;
    }

    @GetMapping(value = "/orderDataById/{id}")
    public OrdersBean getOrdersByIdData(@PathVariable("id") int Id) {

        OrdersBean findProductById = storeGetway.findOrderById(Id);
        return findProductById;
    }

    public StoreGetWay getStoreGetway() {
        return storeGetway;
    }

    public void setStoreGetway(StoreGetWay storeGetway) {
        this.storeGetway = storeGetway;
    }
}
