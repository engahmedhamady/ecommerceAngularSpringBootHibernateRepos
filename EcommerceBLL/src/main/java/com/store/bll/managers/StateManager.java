/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.managers;


import com.store.beans.StateBean;
import java.util.List;

/**
 *
 * @author Sroor For Laptop
 */
public interface StateManager {
    
 List< StateBean>  listAllStates();
    StateBean findStateById(int Id);
       List< StateBean>  findStateByCountryId(int Id);
         StateBean addState(StateBean stateBean);
}