package com.deloitte.practise;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CronProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		System.out.println("Called..");
	}

	
}
