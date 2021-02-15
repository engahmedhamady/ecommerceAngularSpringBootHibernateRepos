package com.store.bll.transformers;

import com.store.beans.CountryBean;
import com.store.beans.StateBean;
import com.store.dal.entities.Country;
import com.store.dal.entities.State;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value = "stateTransformer")
public class StateTransformer {

    public StateBean transformEntityToBean(State entity) {
        if (entity == null) {
            return null;
        }
        StateBean bean = new StateBean();
        // transform
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        CountryBean countryBean = new CountryBean();
        countryBean.setId(entity.getCountry().getId());
        countryBean.setCode(entity.getCountry().getCode());
        countryBean.setName(entity.getCountry().getName());
        bean.setCountry(countryBean);
        return bean;
    }

    public State transformBeanToEntity(StateBean bean) {
        if (bean == null) {
            return null;
        }
        State entity = new State();
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        Country country = new Country();
        country.setId(bean.getCountry().getId());
        country.setName(bean.getCountry().getName());
         country.setCode(bean.getCountry().getCode());
        entity.setCountry(country);
        return entity;
    }
}
