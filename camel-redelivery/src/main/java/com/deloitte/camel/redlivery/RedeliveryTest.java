package com.deloitte.camel.redlivery;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedeliveryTest {

	public static void main(String[] args) {

		AbstractApplicationContext aContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		aContext.start();
		try {
            Thread.sleep(5 * 60 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
		aContext.stop();
		aContext.close();
	}
}
