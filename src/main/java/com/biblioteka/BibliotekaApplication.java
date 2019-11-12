package com.biblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BibliotekaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BibliotekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BibliotekaApplication.class, args);
		/*Logger logger = LoggerFactory.getLogger(SpringApplication.DEFAULT_CONTEXT_CLASS);
		logger.info("Hello Word");*/
    }

}
