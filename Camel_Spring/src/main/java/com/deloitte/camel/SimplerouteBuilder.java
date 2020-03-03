package com.deloitte.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimplerouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:C:/inputfolder?noop=true").to("file:C:/inputfolder/outputfol");
	}

	
}
