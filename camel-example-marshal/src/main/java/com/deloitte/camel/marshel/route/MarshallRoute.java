package com.deloitte.camel.marshel.route;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import com.deloitte.camel.marshel.model.Employee;
import com.deloitte.camel.marshel.processor.MashallProcessor;


public class MarshallRoute  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Employee.class);
		xmlDataFormat.setContext(con);

		// JSON Data Format
		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);

		onException(Exception.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);
		
		/*from("file:C:/inputfolder?noop=true")
		.unmarshal(xmlDataFormat)
		.process(new  MashallProcessor())
		.marshal(jsonDataFormat)
		.to("jms:queue:deloitte");*/
		//jms:queue:deloitte
		from("jms:queue:deloitte")
		//.unmarshal(xmlDataFormat)
		//.process(new  MashallProcessor())
		//.marshal(jsonDataFormat)
		.to("file:C:/inputfolder/f1.txt?noop=true");
	}

	
}
