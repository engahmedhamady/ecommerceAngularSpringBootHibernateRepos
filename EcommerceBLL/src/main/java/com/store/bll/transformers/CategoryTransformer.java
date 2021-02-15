package com.store.bll.transformers;

import com.store.beans.CategoryBean;
import com.store.beans.ProductsBean;
import com.store.dal.entities.Category;
import com.store.dal.entities.Products;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

/**
 *
 * @author ahmed
 */
@Component(value = "categoryTransformer")
public class CategoryTransformer {
     //@Autowired (required = true) 
 //private ProductsTransformer productsTransformer = new ProductsTransformer() ;
           
    public CategoryBean transformEntityToBean(Category entity) {
        if (entity == null) {
            return null;
        }
        CategoryBean bean = new CategoryBean();
        // transform
        bean.setActive(entity.getActive());
        bean.setCategoryId(entity.getId());
        bean.setCategoryName(entity.getCategoryName());
        bean.setDescription(entity.getDescription());
        bean.setPictureUrl(entity.getPictureUrl());
         Set<ProductsBean> set = new HashSet<>();

        for (Products product : entity.getProductses()) {
            ProductsBean productsBean = new ProductsBean();
         //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
            productsBean.setProductId(product.getProductId());
            set.add(productsBean);
        }
        bean.setProductses(set);
        return bean;
    }

    public Category transformBeanToEntity(CategoryBean bean) {
        if (bean == null) {
            return null;
        }
        Category entity = new Category();
        // transform
        entity.setActive(bean.getActive());
        entity.setId(bean.getCategoryId());
        entity.setCategoryName(bean.getCategoryName());
        entity.setDescription(bean.getDescription());
        entity.setPictureUrl(bean.getPictureUrl());
        Set<Products> set = new HashSet<>();

        for (ProductsBean product : bean.getProductses()) {
            //Products products = productsTransformer.transformBeanToEntity(product);
            Products products = new  Products();
           products.setProductId(product.getProductId());
            set.add(products);
        }
        entity.setProductses(set);
        return entity;
    }

//    public ProductsTransformer getProductsTransformer() {
//        return productsTransformer1;
//    }
//
//    public void setProductsTransformer(ProductsTransformer productsTransformer) {
//        this.productsTransformer1 = productsTransformer;
//    }
}
