package com.deloitte.converter.test;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.deloitte.converter.route.CsvToXmlRoute;

public class CsvToXmlTest {

	public static void main(String[] args) {
		
		RouteBuilder route=new CsvToXmlRoute();
		
		CamelContext context=new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try {
			context.addRoutes(route);
			context.start();
			Thread.sleep(5 * 60 * 1000);
			context.stop();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
