package com.immortalidiot.SpringLifeCycle;

import com.immortalidiot.SpringLifeCycle.bean.AnotherBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLifeCycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLifeCycleApplication.class, args);
	}

	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public AnotherBean anotherBean() {
		return new AnotherBean();
	}
}
