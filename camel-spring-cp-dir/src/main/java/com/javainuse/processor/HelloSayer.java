package com.javainuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class HelloSayer implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("Hello.. Welocme to your first Camel Route");
    }

}
