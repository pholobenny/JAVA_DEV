package com.eightbitplatoon.JMSQueueMessageConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApacheRouterApplication.class)
//@SpringBootConfiguration(name =ApacheRouterApplication.class)
public class ApacheRouterApplicationTests {
	@Test
	public void contextLoads() {
	}
}
