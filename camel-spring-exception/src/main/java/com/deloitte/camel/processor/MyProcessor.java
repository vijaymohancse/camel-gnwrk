package com.deloitte.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.deloitte.camel.exception.MyCamelException;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {

			System.out.println("My Processor is called");
			throw new MyCamelException("Marshelling failed");
	}

}
