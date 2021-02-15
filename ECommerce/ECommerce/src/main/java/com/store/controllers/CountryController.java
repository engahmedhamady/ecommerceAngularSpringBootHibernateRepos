package com.store.controllers;

import com.store.beans.CountryBean;
import com.store.bll.delegate.StoreGetWay;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country")
@CrossOrigin("http://localhost:4200")
public class CountryController {

    @Autowired
    private StoreGetWay storeGetway = null;
    
   
    @GetMapping(value = "/countryData")
    public List<CountryBean> getProductData() {
        List<CountryBean> listAllProducts = storeGetway.listAllCountries();
        return listAllProducts;
    }
    @GetMapping(value = "/countryDataById/{id}")
    public CountryBean getProductByIdData(@PathVariable("id")int Id) {
          
       CountryBean findProductById = storeGetway.findCountryById(Id);
        return findProductById;
    }
    
  
    
    
    
//     @GetMapping(value = "/countrySearch/{name}")
//    public  List<ProductsBean>getProductByCategoryData(@PathVariable("name")String name) {
//        List<ProductsBean> listProductsByCategory = storeGetway.listProductsByContain(name);
//         System.out.println(name);
//        return listProductsByCategory;
//    }
//    
//    
    
     
    
    
    public StoreGetWay getStoreGetway() {
        return storeGetway;
    }

    public void setStoreGetway(StoreGetWay storeGetway) {
        this.storeGetway = storeGetway;
    }
}
