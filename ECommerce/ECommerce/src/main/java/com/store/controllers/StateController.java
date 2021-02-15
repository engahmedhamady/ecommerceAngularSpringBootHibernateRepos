package com.store.controllers;

import com.store.beans.StateBean;
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
@RequestMapping(value = "/state")
@CrossOrigin("http://localhost:4200")
public class StateController {

    @Autowired
    private StoreGetWay storeGetway = null;

    @GetMapping(value = "/stateByCountryIdData/{id}")
    public List<StateBean> getProductData(@PathVariable("id") int Id) {
        List<StateBean> listAllProducts = storeGetway.findStateByCountryId(Id);
        return listAllProducts;
    }

    @GetMapping(value = "/stateDataById/{id}")
    public StateBean getProductByIdData(@PathVariable("id") int Id) {

        StateBean findProductById = storeGetway.findStateById(Id);
        return findProductById;
    }

    @PostMapping(value = "/addState")
    public StateBean AddPurchase(@RequestBody StateBean stateBean) {
        StateBean addStateBean = storeGetway.addStateBean(stateBean);

        return addStateBean;
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
