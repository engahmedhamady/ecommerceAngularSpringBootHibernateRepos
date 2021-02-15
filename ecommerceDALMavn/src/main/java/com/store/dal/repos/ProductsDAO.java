package com.store.dal.repos;

import com.store.dal.entities.Category;
import com.store.dal.entities.Products;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("productsDAO")
public class ProductsDAO extends BaseDAO implements commonDAO<Products> {

    // insert 
    @Override
    public Products add(Products admin) {
        getCurrentSession().save(admin);
        return admin;

    }

    @Override
    public Products update(Products admin) {
        getCurrentSession().update(admin);
        return admin;

    }
// delete

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }
// find by name

    @Override
    public Products findById(Object Id) {
        return getCurrentSession().get(Products.class, (int) Id);

    }

    public Products find(Products admin) {
        return getCurrentSession().find(Products.class, admin.getProductId());

    }

    @Override
    public List<Products> findList() {
        Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Products> adminCriteriaQuery = builder.createQuery(Products.class);
        Root<Products> from0 = adminCriteriaQuery.from(Products.class);
        adminCriteriaQuery.select(from0);
        Query<Products> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    public List<Products> findListByCategoryId(Integer categoryID ) {

        Session session = getCurrentSession().getSession();
        List<Products> list = null;

        String querySql = "SELECT * FROM `products` WHERE  categoryID =?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("productID")
                .addScalar("categoryID")
                .addScalar("sku")
                .addScalar("name")
                .addScalar("description")
                .addScalar("create_date")
                .addScalar("unit_in_stock")
                .addScalar("unit_price")
                .addScalar("image_url");
        
        query.setParameter(1, categoryID);
        // List list1 = query.list();
        List<Object[]> list1 = query.list();
        if (list1.size() > 0) {
            list = new ArrayList<>();
            for (Object[] p : list1) {
                Products d = new Products();
                d.setProductId((int) p[0]);
                Category category = new Category();
                category.setId((Integer) p[1]);
                d.setCategory(category);
                d.setSku((String) p[2]);
                d.setName((String) p[3]);
                d.setDescription((String) p[4]);
                d.setCreateDate((Date) p[5]);
                d.setUnitInStock((Integer) p[6]);
                d.setUnitPrice((Integer) p[7]);
                d.setImageUrl((String) p[8]);
              list.add(d);

            }
            return list;
        } else {
            return null;
        }
      
    }

      public List<Products> findListByContainingName(String name) {

        Session session = getCurrentSession().getSession();
        List<Products> list = null;

      //  String querySql = "SELECT * FROM `products` WHERE  name LIKE '%?%'";
       String querySql = "SELECT * FROM `products` WHERE  name LIKE '%"+name+"%'";
        Query query = session.createNativeQuery(querySql)
                .addScalar("productID")
                .addScalar("categoryID")
                .addScalar("sku")
                .addScalar("name")
                .addScalar("description")
                .addScalar("create_date")
                .addScalar("unit_in_stock")
                .addScalar("unit_price")
                .addScalar("image_url");
       // query.setParameter(1, name);
   
        List<Object[]> list1 = query.list();
        if (list1.size() > 0) {
            list = new ArrayList<>();
            for (Object[] p : list1) {
                Products d = new Products();
                d.setProductId((int) p[0]);
                Category category = new Category();
                category.setId((Integer) p[1]);
                d.setCategory(category);
                d.setSku((String) p[2]);
                d.setName((String) p[3]);
                d.setDescription((String) p[4]);
                d.setCreateDate((Date) p[5]);
                d.setUnitInStock((Integer) p[6]);
                d.setUnitPrice((Integer) p[7]);
                d.setImageUrl((String) p[8]);
              list.add(d);

            }
            return list;
        } else {
            return null;
        }
      
    }

    public void patchRemove(List<Products> admins) {
        if (admins == null) {

            return;
        }
        for (Products admin : admins) {
            remove(admin.getProductId());
        }

    }
}
