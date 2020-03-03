package com.deloitte.converter.route;

import org.apache.camel.builder.RouteBuilder;

import com.deloitte.converter.transform.CsvToXmlTransform;

public class CsvToXmlRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		from("file:C:/Users/motprashanth/cameldatafiles/inputfolder?noop=true")
		.process(new CsvToXmlTransform())
		.to("file:C:/Users/motprashanth/cameldatafiles/outputfolder?fileName=employee.xml")
		.to("jms:queue:deloitte");
		
	}

	
}
