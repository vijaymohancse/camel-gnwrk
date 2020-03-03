package com.deloitte.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CronResponseProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		System.out.println("Received the respose from the REST API");
		System.out.println(exchange.getIn().getBody(String.class));
	}

	
}
