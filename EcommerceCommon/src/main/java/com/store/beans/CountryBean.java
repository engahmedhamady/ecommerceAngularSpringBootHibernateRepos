package com.store.beans;

import java.util.HashSet;
import java.util.Set;

public class CountryBean {


     private Integer id;
     private String code;
     private String name;
     private Set<StateBean> states = new HashSet<StateBean>(0);

    public CountryBean() {
    }

    

    public CountryBean(String code, String name, Set<StateBean> states) {
       this.code = code;
       this.name = name;
       this.states = states;
    }
  
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    public Set<StateBean> getStates() {
        return this.states;
    }
    
    public void setStates(Set<StateBean> states) {
        this.states = states;
    }




}


