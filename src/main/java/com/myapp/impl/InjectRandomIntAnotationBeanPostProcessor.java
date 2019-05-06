package com.myapp.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[]  fields = bean.getClass().getDeclaredFields();
        for(Field field: fields){
           InjectRandomInt anotation = field.getAnnotation(InjectRandomInt.class);
           if(anotation != null){
               int min = anotation.min();
               int max = anotation.max();
               Random random = new Random();
               int i = min * random.nextInt(max-min);
               field.setAccessible(true);
               ReflectionUtils.setField(field,bean,i);

           }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
