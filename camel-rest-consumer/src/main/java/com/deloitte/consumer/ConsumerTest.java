package com.deloitte.consumer;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class ConsumerTest {

	public static void main(String[] args) {

		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CamelContext camelContxt=new DefaultCamelContext();
		ConsumerRouteBuilder builder=new ConsumerRouteBuilder();
		
		try {
			camelContxt.addRoutes(builder);
			camelContxt.start();
			Thread.sleep(5 * 60 * 1000);
			camelContxt.stop();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
