package com.eightbitplatoon.JMSQueueMessageConsumer;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Benny
 *
 */
@Component
public class CamelRouter extends RouteBuilder {

    /* (non-Javadoc)
     * @see org.apache.camel.builder.RouteBuilder#configure()
     */
    @Override
	public void configure() throws Exception {
		from("jms:queue:in")
				.log("Checking JSON Message")
			.choice().when().simple("${body} contains '{\"'")
				.log("Displaying message").to("myProcessor")
			.otherwise()
				.log("Message is not JSON")
			.endChoice();
	}
}
