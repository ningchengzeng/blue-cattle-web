package com.bluecattle.web.config.jade4j;

import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;

public class Jade4JTemplateAvailabilityProvider implements TemplateAvailabilityProvider {
    @Override
    public boolean isTemplateAvailable(String view, Environment environment, ClassLoader classLoader, ResourceLoader resourceLoader) {
        if (ClassUtils.isPresent("de.neuland.jade4j.spring.template.SpringTemplateLoader", classLoader)) {
            String prefix = environment.getProperty("spring.jade4j.prefix", Jade4jProperties.DEFAULT_PREFIX);
            String suffix = environment.getProperty("spring.jade4j.suffix", Jade4jProperties.DEFAULT_SUFFIX);
            return resourceLoader.getResource(prefix + view + suffix).exists();
        }
        return false;
    }
}
