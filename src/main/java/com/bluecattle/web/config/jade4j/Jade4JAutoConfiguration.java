package com.bluecattle.web.config.jade4j;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.MimeType;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;
import java.util.Map;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto-configuration} for jade4j.
 *
 * @author Domingo Suarez Torres
 */
@Configuration
@ConditionalOnClass(SpringTemplateLoader.class)
@EnableConfigurationProperties(Jade4jProperties.class)
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class Jade4JAutoConfiguration {

    @Configuration
    @ConditionalOnMissingBean(name = "defaultSpringTemplateLoader")
    public static class DefaultTemplateResolverConfiguration implements ResourceLoaderAware {

        @Autowired
        private Jade4jProperties environment;
        private ResourceLoader resourceLoader;

        @PostConstruct
        public void checkTemplateLocationExists() {
            Boolean checkTemplateLocation = this.environment.getCheckTemplateLocation();
            if (checkTemplateLocation) {
                Resource resource = this.resourceLoader.getResource(this.environment.getPrefix());
                Assert.state(resource.exists(), "Cannot find template location: "
                        + resource + " (please add some templates or check your jade4j configuration)");
            }
        }

        @Bean
        public SpringTemplateLoader defaultSpringTemplateLoader() {
            SpringTemplateLoader resolver = new SpringTemplateLoader();
            resolver.setResourceLoader(this.resourceLoader);
            resolver.setBasePath(this.environment.getPrefix());
            resolver.setSuffix( this.environment.getSuffix());
            resolver.setEncoding(this.environment.getCharsetName());
            return resolver;
        }

        @Bean
        public JadeConfiguration defaultJadeConfiguration() {
            JadeConfiguration configuration = new JadeConfiguration();
            configuration.setCaching( this.environment.getCaching());
            configuration.setTemplateLoader(defaultSpringTemplateLoader());
            configuration.setPrettyPrint(this.environment.getPrettyPrint());
            configuration.setMode(this.environment.getMode());
            return configuration;
        }

        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }
    }


    @Configuration
    @ConditionalOnClass({Servlet.class})
    @ConditionalOnWebApplication
    protected static class Jade4JViewResolverConfiguration {

        @Autowired
        private Jade4jProperties environment;
        @Autowired
        private JadeConfiguration jadeConfiguration;

        @Bean
        @ConditionalOnMissingBean(name = "jade4jViewResolver")
        @ConditionalOnProperty(name = "spring.jade4j.enabled", matchIfMissing = true)
        public JadeViewResolver jade4jViewResolver() {
            JadeViewResolver resolver = new JadeViewResolver();
            jadeConfiguration.setMode(this.environment.getMode());

            resolver.setConfiguration(jadeConfiguration);
            resolver.setContentType(this.environment.getContentType().toString());
            resolver.setViewNames(this.environment.getViewNames());
            resolver.setOrder(this.environment.getResolverOrder());
            return resolver;
        }

        @Bean
        public BeanPostProcessor jade4jBeanPostProcessor() {
            return new BeanPostProcessor() {

                @Override
                public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                    return bean;
                }

                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    JadeHelper annotation = AnnotationUtils.findAnnotation(bean.getClass(), JadeHelper.class);
                    if (annotation != null) {
                        Map<String, Object> variables = jadeConfiguration.getSharedVariables();
                        variables.put(beanName, bean);
                        jadeConfiguration.setSharedVariables(variables);
                    }

                    return bean;
                }
            };
        }
    }
}

