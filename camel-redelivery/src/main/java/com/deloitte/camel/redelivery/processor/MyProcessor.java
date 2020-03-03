package com.deloitte.camel.redelivery.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.deloitte.camel.redelivery.exception.MyCamelException;

public class MyProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		String msg=exchange.getIn().getBody(String.class);
		System.out.println("Hello "+msg);
		if(msg.equals("prashanth")) {
			throw new MyCamelException("Invalid message");
		}
	}

	
}
