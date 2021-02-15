package com.store.beans;



public class StateBean {


     private Integer id;
    private CountryBean country;
     private String name;

    public StateBean() {
    }

    public StateBean(Integer id, CountryBean country, String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }

public StateBean(Integer id,  String name) {
        this.id = id;
  
        this.name = name;
    }

	
    public StateBean(CountryBean country) {
        this.country = country;
    }
    public StateBean(CountryBean country, String name) {
       this.country = country;
       this.name = name;
    }
   

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public CountryBean getCountry() {
        return this.country;
    }
    
    public void setCountry(CountryBean country) {
        this.country = country;
    }

    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


