package com.eightbitplatoon.JMSQueueMessageConsumer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean implements Processor {

	private static Logger LOGGER = LoggerFactory.getLogger(MyBean.class.getName());

	@Override
	public final void process(final Exchange exchange) throws Exception {
		String msg = exchange.getIn().getBody().toString();
		LOGGER.info(msg);
	}
}
