package com.immortalidiot.SpringLifeCycle.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements InitializingBean, DisposableBean {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public MyBean() {
        System.out.println("MyBean: Constructor");
    }

    @PostConstruct
    public void postConstruct() {
        state = "INIT";
        System.out.println("MyBean: PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean: InitializingBean's afterPropertiesSet");
    }

    public void customInit() {
        System.out.println("MyBean: Custom init method");
    }

    @PreDestroy
    public void preDestroy() {
        state = "DESTROY";
        System.out.println("MyBean: PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyBean: DisposableBean's destroy");
    }

    public void customDestroy() {
        System.out.println("MyBean: Custom destroy method");
    }

//    init order:
//    constructor,
//    pre init for myBean,
//    post construct,set props, custom init,
//    post init
//    work
//    pre-destroy, destroy, custom destroy
}
