package com.deloitte.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import com.deloitte.consumer.Employee;;

public class ConsumerRouteBuilder extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		
		onException(Exception.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);
		
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
		from("quartz://report?cron=0+0/1+12-18+?+*+MON-FRI")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				
				Employee employee=new Employee();
				employee.setEmpName("KIopp");
				employee.setOrgName("Klklkl");
				
				exchange.getIn().setBody(employee);
			}
		}).marshal(jsonDataFormat)
		.setHeader(Exchange.HTTP_METHOD, simple("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to("http://localhost:8080/employee/save")
		.process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
				
				System.out.println(exchange.getIn().getBody(String.class));
			}
		});
	
	}

	
}
