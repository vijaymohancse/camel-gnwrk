package com.deloitte.activemq.test;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActiveMqStarter {

	public static void main(String[] args) {

		
//		CamelContext camelContext = new DefaultCamelContext();
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
//		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory)); 
 

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

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
