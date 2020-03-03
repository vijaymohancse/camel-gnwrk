package com.deloitte.camel.redelivery.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.RedeliveryPolicy;

import com.deloitte.camel.redelivery.exception.MyCamelException;
import com.deloitte.camel.redelivery.processor.MyProcessor;
import com.deloitte.camel.redelivery.processor.RedeliveryProcessor;

public class SimpleRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		onException(MyCamelException.class).process(new Processor() {
			
			 public void process(Exchange exchange) throws Exception {
	                System.out.println("handling ex");
	            }
			
		}).onRedelivery(new RedeliveryProcessor()).redeliveryPolicyRef("testRedeliveryPolicyProfile").log("Received body ").handled(true);
		
		from("file:C:/inputfolder?noop=true").process(new MyProcessor()).to("file:C:/inputfolder/outputfol");
	}
}
