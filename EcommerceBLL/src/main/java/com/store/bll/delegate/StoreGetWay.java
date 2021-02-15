/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.delegate;

import com.store.bll.impl.CategoryManagerImpl;
import com.store.bll.impl.CountryManagerImpl;
import com.store.bll.impl.OrdersManagerImpl;
import com.store.bll.impl.ProductsManagerImpl;

import com.store.bll.impl.StateManagerImpl;
import com.store.beans.CategoryBean;
import com.store.beans.CountryBean;
import com.store.beans.OrdersBean;
import com.store.beans.ProductsBean;
import com.store.beans.StateBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "getWay")
public class StoreGetWay {

    @Autowired(required = true)
    private ProductsManagerImpl productsManagerImpl;

    public ProductsManagerImpl getProductsManagerImpl() {
        return productsManagerImpl;
    }

    public void setProductsManagerImpl(ProductsManagerImpl productsManagerImpl) {
        this.productsManagerImpl = productsManagerImpl;
    }

    public List<ProductsBean> listAllProducts() {
        return productsManagerImpl.listAllProducts();
    }

    public ProductsBean findProductById(int Id) {
        return productsManagerImpl.findProductById(Id);
    }

    public List<ProductsBean> listProductsByCategory(Integer Id ) {
        return productsManagerImpl.listProductsByCategory(Id );
    }

    public List<ProductsBean> listProductsByContain(String name) {
        return productsManagerImpl.listProductsByContain(name);
    }
    //=========================================================================  

    @Autowired(required = true)
    private CategoryManagerImpl categoryManagerImpl;

    public CategoryManagerImpl getCategoryManagerImpl() {
        return categoryManagerImpl;
    }

    public void setCategoryManagerImpl(CategoryManagerImpl categoryManagerImpl) {
        this.categoryManagerImpl = categoryManagerImpl;
    }

    public List<CategoryBean> listAllCategories() {
        return categoryManagerImpl.listAllCategories();
    }

    public CategoryBean findCategoryById(int Id) {
        return categoryManagerImpl.findCategoryById(Id);
    }
    
//=================================================================================
    @Autowired(required = true)
    private OrdersManagerImpl ordersManagerImpl;

    public OrdersManagerImpl getOrdersManagerImpl() {
        return ordersManagerImpl;
    }

    public void setOrdersManagerImpl(OrdersManagerImpl ordersManagerImpl) {
        this.ordersManagerImpl = ordersManagerImpl;
    }

    public List<OrdersBean> listAllOrders() {
        return ordersManagerImpl.listAllOrders();
    }

    public OrdersBean findOrderById(int Id) {
        return ordersManagerImpl.findOrderById(Id);
    }

    public OrdersBean addPurchase(OrdersBean ordersBean) {
        return ordersManagerImpl.addPurchase(ordersBean);
    }

  
   ///==============================================================
    
    @Autowired(required = true)
    private CountryManagerImpl countryManagerImpl;

    public CountryManagerImpl getCountryManagerImpl() {
        return countryManagerImpl;
    }

    public void setCountryManagerImpl(CountryManagerImpl countryManagerImpl) {
        this.countryManagerImpl = countryManagerImpl;
    }
      public List<CountryBean> listAllCountries() {
        return countryManagerImpl.listAllCountries();
    }

    public CountryBean findCountryById(int Id) {
        return countryManagerImpl.findCountryById(Id);
    }
//========================================================================
     @Autowired(required = true)
    private StateManagerImpl stateManagerImpl;

    public StateManagerImpl getStateManagerImpl() {
        return stateManagerImpl;
    }

    public void setStateManagerImpl(StateManagerImpl stateManagerImpl) {
        this.stateManagerImpl = stateManagerImpl;
    }

    public List<StateBean> listAllStates() {
        return stateManagerImpl.listAllStates();
    }

    public StateBean findStateById(int Id) {
        return stateManagerImpl.findStateById(Id);
    }

    public List<StateBean> findStateByCountryId(int Id) {
        return stateManagerImpl.findStateByCountryId(Id);
    }
         public StateBean addStateBean( StateBean stateBean) {
        return stateManagerImpl.addState(stateBean);
    }
  //==========================================================

  
    
}
