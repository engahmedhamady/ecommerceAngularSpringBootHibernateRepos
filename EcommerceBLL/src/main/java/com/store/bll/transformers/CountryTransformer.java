package com.store.bll.transformers;

import com.store.beans.CountryBean;
import com.store.beans.StateBean;
import com.store.dal.entities.Country;
import com.store.dal.entities.State;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value = "countryTransformer")
public class CountryTransformer {

    public CountryBean transformEntityToBean(Country entity) {
        if (entity == null) {
            return null;
        }
        CountryBean bean = new CountryBean();
        // transform
        bean.setCode(entity.getCode());
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        Set<StateBean> set = new HashSet<>();
        for (State state : entity.getStates()) {
            StateBean stateBean = new StateBean();
            stateBean.setId(state.getId());
            stateBean.setName(state.getName());

            set.add(stateBean);
        }
        bean.setStates(set);
        return bean;
    }

    public Country transformBeanToEntity(CountryBean bean) {
        if (bean == null) {
            return null;
        }
        Country entity = new Country();
        entity.setCode(bean.getCode());
        entity.setId(bean.getId());
        entity.setName(bean.getName());
        Set<State> set = new HashSet<>();
        for (StateBean stateBean : bean.getStates()) {
            State state = new State();
            state.setId(state.getId());
            set.add(state);
        }
        entity.setStates(set);
        return entity;
    }
}
