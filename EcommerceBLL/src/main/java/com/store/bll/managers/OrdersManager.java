/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.managers;

import com.store.beans.OrdersBean;
import com.store.beans.PurchaseBean;
import java.util.List;

/**
 *
 * @author Sroor For Laptop
 */
public interface OrdersManager {
  List< OrdersBean>  listAllOrders();  
   OrdersBean findOrderById(int Id);
    OrdersBean addPurchase( OrdersBean ordersBean);
   
}
