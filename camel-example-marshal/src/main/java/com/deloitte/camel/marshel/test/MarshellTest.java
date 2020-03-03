package com.deloitte.camel.marshel.test;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.deloitte.camel.marshel.route.MarshallRoute;

public class MarshellTest {

	public static void main(String[] args) {
		
		MarshallRoute routeBuilder=new MarshallRoute();
		
		CamelContext camelContext=new DefaultCamelContext();
		   ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		   camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try {
			camelContext.addRoutes(routeBuilder);
			camelContext.start();
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
