package com.bluecattle.web.config;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

/**
 * web 配置
 * @author ningchengzeng
 */
@Configuration
public class JadeConfig {

    @Autowired
    private JadeProperties jadeProperties;

    /**
     *
     * @return
     */
    @Bean
    public SpringTemplateLoader templateLoader() {
        SpringTemplateLoader templateLoader = new SpringTemplateLoader();
        templateLoader.setBasePath(jadeProperties.getPath());
        templateLoader.setEncoding(jadeProperties.getEncoding());
        templateLoader.setSuffix(jadeProperties.getSuffix());
        return templateLoader;
    }

    /**
     *
     * @return
     */
    @Bean
    public JadeConfiguration jadeConfiguration() {
        JadeConfiguration configuration = new JadeConfiguration();
        configuration.setCaching(false);
        configuration.setMode(Jade4J.Mode.HTML);
        configuration.setTemplateLoader(templateLoader());
        return configuration;
    }

    @Bean
    public ViewResolver viewResolver() {
        JadeViewResolver viewResolver = new JadeViewResolver();
        viewResolver.setConfiguration(jadeConfiguration());
        return viewResolver;
    }
}
