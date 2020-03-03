package com.deloitte.camel.marshel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.deloitte.camel.marshel.model.Employee;

public class MashallProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		
		Employee employee=exchange.getIn().getBody(Employee.class);
		exchange.getIn().setBody(employee);
	}

	
}
