package com.deloitte.practise;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CronResponseProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
	
		System.out.println(exchange.getIn().getBody(String.class));
	}

	
}
