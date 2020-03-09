package com.deloitte.parallelprocessing.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RemoveExtensionProcessor implements Processor{

	
	public void process(Exchange exchange) throws Exception {
		
		String header=(String) exchange.getIn().getHeader("CamelFileName");
			header=(String) header.subSequence(0, header.indexOf("."));
			exchange.getIn().setHeader("CamelFileName", header);
		}
}
