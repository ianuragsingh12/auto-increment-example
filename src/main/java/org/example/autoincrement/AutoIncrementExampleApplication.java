package org.example.autoincrement;

import org.example.autoincrement.count.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoIncrementExampleApplication {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private Test cs;

    public static void main(String[] args) {
        SpringApplication.run(AutoIncrementExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return (String[] args) -> {
            LOG.debug("========================================");
            LOG.debug("Total Beans = " + appContext.getBeanDefinitionCount());
            cs.save("my");
            cs.save("name");
            cs.save("is");
            cs.save("Anthony");
            cs.save("Gonsalvis");
            LOG.debug("========================================");
        };
    }
}
