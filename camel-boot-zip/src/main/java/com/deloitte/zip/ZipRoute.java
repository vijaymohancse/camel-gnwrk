package com.deloitte.zip;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.zipfile.ZipSplitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ZipRoute extends RouteBuilder{
	
	Logger logger=LoggerFactory.getLogger(ZipRoute.class);

	@Override
	public void configure() throws Exception {
		
		from("file:C:/Users/motprashanth/cameldatafiles/Zip?delay=1000&noop=true")
	    .split(new ZipSplitter()).streaming()
	        
	    .to("file:C:/Users/motprashanth/cameldatafiles/outfolder");
		System.out.println("----------");
	}

}
