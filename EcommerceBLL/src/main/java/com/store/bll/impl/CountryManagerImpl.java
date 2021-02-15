/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.CountryManager;
import com.store.bll.transformers.CountryTransformer;
import com.store.beans.CountryBean;
import com.store.dal.entities.Country;
import com.store.dal.repos.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value ="countryManagerImpl")
public class CountryManagerImpl implements CountryManager{

     @Autowired(required = true)
    private CountryDAO countryDAO;
    @Autowired(required = true)
    private CountryTransformer countryTransformer;

    @Transactional
    
    @Override
    public List<CountryBean> listAllCountries() {
         //To change body of generated methods, choose Tools | Templates.
          List<CountryBean> find = null;
        List<Country> findList = countryDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (Country p : findList) {

                find.add(countryTransformer.transformEntityToBean(p));
            }
        }

        return find;
         
    }

    @Override
    public CountryBean findCountryById(int Id) {
     //To change body of generated methods, choose Tools | Templates.
     CountryBean find = null;
        Country findById = countryDAO.findById(Id);
        if (findById != null) {

            find = countryTransformer.transformEntityToBean(findById);
        }

        return find;
     
     
    }
    
}
