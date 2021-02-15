/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.store.bll.delegate.StoreGetWay;
import com.store.beans.ProductsBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Sroor For Laptop
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/store/bll/config/bll-spring-context.xml");
        StoreGetWay bean = context.getBean("getWay", StoreGetWay.class);
        ProductsBean get = bean.listAllProducts().get(0);
        System.out.println(get.getName());
    }
}
