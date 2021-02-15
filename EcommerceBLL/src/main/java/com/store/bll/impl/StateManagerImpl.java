/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.StateManager;
import com.store.bll.transformers.StateTransformer;

import com.store.beans.StateBean;
import com.store.dal.entities.State;
import com.store.dal.repos.StateDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value ="stateManagerImpl")
public class StateManagerImpl implements StateManager{

     @Autowired(required = true)
    private StateDAO stateDAO;
    @Autowired(required = true)
    private StateTransformer stateTransformer;

    @Transactional
    
    @Override
    public List<StateBean> listAllStates() {
         //To change body of generated methods, choose Tools | Templates.
          List<StateBean> find = null;
        List<State> findList = stateDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (State p : findList) {

                find.add(stateTransformer.transformEntityToBean(p));
            }
        }

        return find;
         
    }

    @Override
    public StateBean findStateById(int Id) {
     //To change body of generated methods, choose Tools | Templates.
     StateBean find = null;
        State findById = stateDAO.findById(Id);
        if (findById != null) {

            find = stateTransformer.transformEntityToBean(findById);
        }

        return find;
     
     
    }

    @Override
    public List<StateBean> findStateByCountryId(int Id) {
         List<StateBean> find = null;
        List<State> findList = stateDAO.findListStateByCountryId(Id);
        if (findList != null) {
            find = new ArrayList();
            for (State p : findList) {

                find.add(stateTransformer.transformEntityToBean(p));
            }
        }
       return find;
    }

    @Override
    public StateBean addState(StateBean stateBean) {
      //To change body of generated methods, choose Tools | Templates.
      if (stateBean == null) {
            return null ;
        } else {
            
            State transformBeanToEntity = stateTransformer.transformBeanToEntity(stateBean);
            
           stateDAO.add(transformBeanToEntity);
           
            return stateTransformer.transformEntityToBean(transformBeanToEntity);

        }
    }
    
}
