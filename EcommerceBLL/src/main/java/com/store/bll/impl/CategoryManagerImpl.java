
package com.store.bll.impl;

import com.store.bll.managers.*;
import com.store.bll.transformers.CategoryTransformer;
import com.store.beans.CategoryBean;
import com.store.dal.entities.Category;
import com.store.dal.repos.CategoryDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("categoryManagerImpl")
public class CategoryManagerImpl implements CategoryManager {
@Autowired(required = true)
    private CategoryDAO categoryDAO;
    @Autowired(required = true)
    private CategoryTransformer categoryTransformer;
 @Transactional
    @Override
    public List<CategoryBean> listAllCategories() {
       List<CategoryBean> find = null;
        List<Category> findList = categoryDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (Category p : findList) {

                find.add(categoryTransformer.transformEntityToBean(p));
            }
        }

        return find; 
    }
 @Transactional
    @Override
    public CategoryBean findCategoryById(int Id) {
          CategoryBean find = null;
        Category findById = categoryDAO.findById(Id);
        if (findById != null) {

            find = categoryTransformer.transformEntityToBean(findById);
        }

        return find;  
    }
    
}
