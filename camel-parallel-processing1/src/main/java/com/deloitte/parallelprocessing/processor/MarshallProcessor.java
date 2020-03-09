package com.deloitte.parallelprocessing.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class MarshallProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {

		com.deloitte.parallelprocessing.model.Employee employee = exchange.getIn()
				.getBody(com.deloitte.parallelprocessing.model.Employee.class);
		exchange.getIn().setBody(employee);

	}

}
