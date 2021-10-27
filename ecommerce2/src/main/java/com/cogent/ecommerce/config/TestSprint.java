package com.cogent.ecommerce.config;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSprint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Config.class);
		
		DataSource dataSource= applicationContext.getBean("getDataSource", DataSource.class);
		
		System.out.println(dataSource.hashCode());
		System.out.println(dataSource.hashCode());
		DataSource dataSource2= applicationContext.getBean("getDataSource", DataSource.class);
		System.out.println(dataSource.equals(dataSource2));

	}

}
