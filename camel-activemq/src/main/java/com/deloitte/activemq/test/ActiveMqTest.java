package com.deloitte.activemq.test;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.deloitte.activemq.route.ActiveMqRoute;

public class ActiveMqTest {

	public static void main(String[] args) {

		ActiveMqRoute route = new ActiveMqRoute();
		CamelContext camelContext = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		try {
			camelContext.addRoutes(route);
			camelContext.start();
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
