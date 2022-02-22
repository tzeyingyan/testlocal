package com.local.test.activemq.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class SpringComposantConsommateur {
    private static final Logger logger = LoggerFactory.getLogger(SpringComposantConsommateur.class);
    private static final String QUEUE = "local.activemq.test1";

    @JmsListener(destination = QUEUE)
    public void consumeMessage(String message) {
        logger.info("Message received from activemq queue---"+message);
    }
}
