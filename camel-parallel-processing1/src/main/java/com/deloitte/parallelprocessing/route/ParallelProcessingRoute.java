package com.deloitte.parallelprocessing.route;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

public class ParallelProcessingRoute extends RouteBuilder {
	String header=new String();
	@Override
	public void configure() throws Exception {

		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(com.deloitte.parallelprocessing.model.Employee.class);
		xmlDataFormat.setContext(con);
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		// JSON Data Format
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(com.deloitte.parallelprocessing.model.Employee.class);

		from("file:C:/inputfolder?noop=true")
		.choice()
		.when(header("CamelFileName").endsWith(".xml"))
		.split(body()).streaming().parallelProcessing()
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
					 header=(String) exchange.getIn().getHeader("CamelFileName");
						header=(String) header.subSequence(0, header.indexOf("."));
						exchange.getIn().setHeader("CamelFileName", header);
					}
				})
				.log("Starting to process big file: ${header.CamelFileName}").unmarshal(xmlDataFormat)
				.process(new com.deloitte.parallelprocessing.processor.MarshallProcessor()).marshal(jsonDataFormat)
				.to("file:C:/inputfolde?fileName=${header.CamelFileName}.json");
	}

}
