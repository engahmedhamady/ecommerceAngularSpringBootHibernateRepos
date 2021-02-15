/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.managers;

import com.store.beans.CategoryBean;
import com.store.beans.CountryBean;
import java.util.List;

/**
 *
 * @author Sroor For Laptop
 */
public interface CountryManager {
    
 List< CountryBean>  listAllCountries();
    CountryBean findCountryById(int Id);
}