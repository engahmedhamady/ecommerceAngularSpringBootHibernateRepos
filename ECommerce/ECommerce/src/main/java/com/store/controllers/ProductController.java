package com.store.controllers;

import com.store.beans.OrdersBean;
import com.store.beans.ProductsBean;
import com.store.bll.delegate.StoreGetWay;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    private StoreGetWay storeGetway = null;
    
   
    @GetMapping(value = "/productData")
    public List<ProductsBean> getProductData() {
        List<ProductsBean> listAllProducts = storeGetway.listAllProducts();
        return listAllProducts;
    }
    @GetMapping(value = "/productDataById/{id}")
    public ProductsBean getProductByIdData(@PathVariable("id")int Id) {
          
        ProductsBean findProductById = storeGetway.findProductById(Id);
        return findProductById;
    }
    
    @GetMapping(value = "/productDataByCategory/{id}")
    public  List<ProductsBean>getProductByCategoryData(@PathVariable("id")Integer Id) {
        List<ProductsBean> listProductsByCategory = storeGetway.listProductsByCategory(Id);
        System.out.println(Id);
        return listProductsByCategory;
    }
    
    
    
     @GetMapping(value = "/productSearch/{name}")
    public  List<ProductsBean>getProductByCategoryData(@PathVariable("name")String name) {
        List<ProductsBean> listProductsByCategory = storeGetway.listProductsByContain(name);
         System.out.println(name);
        return listProductsByCategory;
    }
    
    
    
      @GetMapping(value = "/orders")
    public  List<OrdersBean>getPurchase() {
        List<OrdersBean> listProductsByCategory = storeGetway.listAllOrders();
       
        return listProductsByCategory;
    }
      @GetMapping(value = "/orderDataById/{id}")
        public OrdersBean getOrdersByIdData(@PathVariable("id")int Id) {
          
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
