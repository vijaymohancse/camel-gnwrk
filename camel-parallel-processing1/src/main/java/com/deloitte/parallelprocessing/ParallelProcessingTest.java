package com.deloitte.parallelprocessing;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deloitte.parallelprocessing.route.ParallelProcessingRoute;


public class ParallelProcessingTest {

	public static void main(String[] args) {

		
		/*  CamelContext camelContext = new DefaultCamelContext();
		  
		  try { camelContext.addRoutes(new ParallelProcessingRoute());
		  camelContext.start(); Thread.sleep(5 * 60 * 1000); camelContext.stop();
		  }catch (Exception e) {
		  
		  }*/
		 

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		context.start();
		try {
			Thread.sleep(5 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.stop();
		context.close();
	}
}
