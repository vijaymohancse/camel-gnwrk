package com.deloitte.practise;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExceptionProcessor  implements Processor{

	public void process(Exchange exchange) throws Exception {

			System.out.println("Exception Handled..");
	}

	
}
