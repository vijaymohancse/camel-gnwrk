package com.deloitte.activemq.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class ActiveMqRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		onException(Exception.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);

		//from("file:C:/inputfolder?noop=true").to("jms:queue:deloitte");
		
		
		from("jms:queue:deloitte").to("file:C:/inputfolder?fileName=jms.txt");
	}

	
}
