package com.deloitte.camel.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import com.deloitte.camel.exception.MyCamelException;
import com.deloitte.camel.processor.MyProcessor;

public class SimpleRoute  extends RouteBuilder{

	//do try
	/*@Override
	public void configure() throws Exception {
		
		from("file:C:/inputfolder?noop=true").doTry().process(new MyProcessor())
		.to("file:C:/inputfolder/outputfol").doCatch(MyCamelException.class).process(new MyProcessor() {
			
			public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
		}).log("Message received.");
	}*/
	
	@Override
    public void configure() throws Exception {

        onException(MyCamelException.class).process(new MyProcessor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);

        from("file:C:/inputfolder?noop=true").process(new MyProcessor()).to("file:C:/inputfolder/outputfol");

       // from("file:C:/inbox?noop=true").process(new MyProcessor()).to("file:C:/outputFolder");
    }

	
}
