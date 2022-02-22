package com.local.test.activemq.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.local.test.activemq.spring",
        exclude = ThymeleafAutoConfiguration.class)
public class SpringMainApplication {
        public static void main(String[] args) {
            SpringApplication.run(SpringMainApplication.class, args);
        }
}
