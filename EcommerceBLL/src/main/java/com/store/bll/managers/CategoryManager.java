/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.managers;

import com.store.beans.CategoryBean;
import java.util.List;

/**
 *
 * @author Sroor For Laptop
 */
public interface CategoryManager {
    
 List< CategoryBean>  listAllCategories();
    CategoryBean findCategoryById(int Id);
}