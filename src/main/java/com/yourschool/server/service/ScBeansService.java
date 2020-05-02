package com.yourschool.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.yourschool.server.config.Beans;

@Service
public class ScBeansService {
	
	@Autowired
    private ApplicationContext applicationContext;
	
	public Beans getBeans() {
		Beans beans = (Beans) applicationContext.getBean(Beans.class);
		return beans != null? beans: null;
	}

}
