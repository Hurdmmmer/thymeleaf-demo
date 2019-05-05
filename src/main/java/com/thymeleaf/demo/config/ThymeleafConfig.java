package com.thymeleaf.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configurable
public class ThymeleafConfig {
    @Bean
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();

        SpringSecurityDialect dialect = new SpringSecurityDialect();
        templateEngine.addDialect(dialect);

        return templateEngine;
    }
}
