package com.deloitte.cron.test;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

public class CronTest {

	public static void main(String[] args) {
		
		CamelContext camelContext=new DefaultCamelContext();
		try {
			camelContext.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					
					onException(Exception.class).process(new Processor() {

			            public void process(Exchange exchange) throws Exception {
			                System.out.println("handling ex");
			            }
			        }).log("Received body ").handled(true);
					
					from("quartz://report?cron=0+0/1+12-18+?+*+MON-FRI").process(new Processor() {
						
						public void process(Exchange exchange) throws Exception {
							System.out.println("Hello");							
						}
					}).setHeader(Exchange.HTTP_METHOD, simple("GET"))
					.to("http://localhost:8080/employee/getEmployee/3")
					.process(new Processor() {
						
						public void process(Exchange exchange) throws Exception {
							System.out.println(exchange.getIn().getBody(String.class));
						}
					});
					
				/*	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
					from("quartz://report?cron=0+0/1+12-18+?+*+MON-FRI").process(new Processor() {

						public void process(Exchange exchange) throws Exception {
							System.out.println("Hello");
							Employee employee=new Employee();
							employee.setEmpName("HJkkk");
							employee.setOrgName("rteerr");
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
							});*/
				}
				
				
			});
			camelContext.start();
			Thread.sleep(5 * 60 * 1000);
			camelContext.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
