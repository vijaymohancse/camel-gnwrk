package com.deloitte.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CronRequestProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		System.out.println("Invoked the REST API");
	}
	
}
