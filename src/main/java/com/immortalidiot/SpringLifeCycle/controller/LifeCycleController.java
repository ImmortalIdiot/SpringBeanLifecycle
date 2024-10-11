package com.immortalidiot.SpringLifeCycle.controller;

import com.immortalidiot.SpringLifeCycle.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifecycle")
public class LifeCycleController {

    public MyBean myBean;

    @Autowired
    public LifeCycleController(MyBean myBean) {
        this.myBean = myBean;
    }

    @GetMapping("/state")
    public String currentBeanState() {
        return "Bean state: " + myBean.getState();
    }

    @PostMapping("/state")
    public String updateBeanState(String newState) {
        myBean.setState(newState);
        return "Bean state updated to: " + myBean.getState();
    }
}
