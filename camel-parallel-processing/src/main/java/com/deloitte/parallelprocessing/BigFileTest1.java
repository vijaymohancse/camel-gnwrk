package com.deloitte.parallelprocessing;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BigFileTest1 {

	public static void main(String[] args) {
		
		CamelContext camelContext=new DefaultCamelContext();
		//AbstractApplicationContext camelContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
			camelContext.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					/*from("file:C:/Users/motprashanth/cameldatafiles/target/inventory?noop=true")
                    //.log("Starting to process big file: ${header.CamelFileName}")
					
                    .split(body().tokenize("\n")).streaming().parallelProcessing()
                       .bean(InventoryService.class, "csvToObject")
                        .to("file:C:/Users/motprashanth/cameldatafiles/target/inventory/output")
                    .end();
                  //  .log("Done processing big file: ${header.CamelFileName}");
*/
                from("file:C:/Users/motprashanth/cameldatafiles/target/inventory?noop=true")
                .multicast().parallelProcessing()
                .to("file:C:/Users/motprashanth/cameldatafiles/target/inventory/output1","file:C:/Users/motprashanth/cameldatafiles/target/inventory/output2");
                    
				}
				
			});
			camelContext.start();
			Thread.sleep(5*60*1000);
			camelContext.stop();
			//camelContext.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
