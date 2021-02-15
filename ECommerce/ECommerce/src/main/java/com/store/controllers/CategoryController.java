package com.store.controllers;

import com.store.beans.CategoryBean;
import com.store.bll.delegate.StoreGetWay;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    @Autowired
    private StoreGetWay storeGetway = null;
    
   
    @GetMapping(value = "/findCategoryList")
    public List<CategoryBean> getCategoryData() {
        List<CategoryBean> listAllProducts = storeGetway.listAllCategories();
        return listAllProducts;
    }
    @GetMapping(value = "/categoryDataById")
    public CategoryBean getCategoryByIdData(@RequestParam("id")int Id) {
        CategoryBean findCategoryById = storeGetway.findCategoryById(Id);
        return findCategoryById;
    }
    public StoreGetWay getStoreGetway() {
        return storeGetway;
    }

    public void setStoreGetway(StoreGetWay storeGetway) {
        this.storeGetway = storeGetway;
    }
}
