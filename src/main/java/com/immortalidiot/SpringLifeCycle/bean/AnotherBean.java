package com.immortalidiot.SpringLifeCycle.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("myBean")
public class AnotherBean implements InitializingBean, DisposableBean {
    private MyBean myBean;

    public AnotherBean() {
        System.out.println("AnotherBean: Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("AnotherBean: PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AnotherBean: InitializingBean's afterPropertiesSet");
    }

    public void customInit() {
        System.out.println("AnotherBean: Custom init method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("AnotherBean: PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("AnotherBean: DisposableBean's destroy");
    }

    public void customDestroy() {
        System.out.println("AnotherBean: Custom destroy method");
    }

    //myBean constructor
    //pre-init myBean
    //myBean post constructor
    //set properties myBean
    //anotherBean constructor
    //anotherBean post constructor
    //set properties anotherBean
    //custom init anotherBean
    //pre-destroy another bean, disposable destroy, custom destroy
    //pre-destroy my bean, disposable destroy
}
