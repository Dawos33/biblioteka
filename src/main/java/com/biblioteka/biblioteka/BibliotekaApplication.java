package com.biblioteka.biblioteka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotekaApplication.class, args);
		Logger logger = LoggerFactory.getLogger(SpringApplication.DEFAULT_CONTEXT_CLASS);
		logger.info("Hello Word");
    }

}
