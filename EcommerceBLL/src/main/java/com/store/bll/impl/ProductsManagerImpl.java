/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.*;
import com.store.bll.transformers.ProductsTransformer;
import com.store.beans.ProductsBean;
import com.store.dal.entities.Products;
import com.store.dal.repos.ProductsDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value ="productsManagerImpl")
public class ProductsManagerImpl implements ProductsManager {

    @Autowired(required = true)
    private ProductsDAO productsDAO;
    @Autowired(required = true)
    private ProductsTransformer productsTransformer;

    @Transactional
    @Override
    public List<ProductsBean> listAllProducts() {
        List<ProductsBean> find = null;
        List<Products> findList = productsDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (Products p : findList) {

                find.add(productsTransformer.transformEntityToBean(p));
            }
        }

        return find;
    }

    @Override
    public ProductsBean findProductById(int Id) {
        ProductsBean find = null;
        Products findById = productsDAO.findById(Id);
        if (findById != null) {

            find = productsTransformer.transformEntityToBean(findById);
        }

        return find;
    }

    @Override
    public List<ProductsBean> listProductsByCategory(Integer Id ) {
          List<ProductsBean> find = null;
        List<Products> findList = productsDAO.findListByCategoryId(Id);
        if (findList != null) {
            find = new ArrayList();
            for (Products p : findList) {

                find.add(productsTransformer.transformEntityToBean(p));
            }
        }

        return find;
    }

    @Override
    public List<ProductsBean> listProductsByContain(String name) {
            List<ProductsBean> find = null;
        List<Products> findList = productsDAO.findListByContainingName(name);
        if (findList != null) {
            find = new ArrayList();
            for (Products p : findList) {

                find.add(productsTransformer.transformEntityToBean(p));
            }
        }

        return find;
    }

}
