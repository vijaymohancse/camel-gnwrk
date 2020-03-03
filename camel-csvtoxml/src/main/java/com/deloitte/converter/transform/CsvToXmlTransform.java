package com.deloitte.converter.transform;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CsvToXmlTransform implements Processor {

	public void process(Exchange exchange) throws Exception {

		String message = exchange.getIn().getBody(String.class);
		String[] employees = message.split(System.getProperty("line.separator"));
		StringBuffer employeeXml = new StringBuffer();
		employeeXml.append("<employees>");

		for (String employee : employees) {

			String[] values = employee.split(",");
			employeeXml.append("<employee>");
			employeeXml.append("<employee_id>" + values[0] + "</employee_id>");
			employeeXml.append("<employee_name>" + values[1] + "</employee_name>");
			employeeXml.append("<employee_organization>" + values[2] + "</employee_organization>");
			employeeXml.append("</employee>");
		} //
		employeeXml.append("</employees>");
		System.out.println("MyProcess has completed.");
		exchange.getIn().setBody(employeeXml);
	}

}
