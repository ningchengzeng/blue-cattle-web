package com.bluecattle.web.config.jade4j;

import de.neuland.jade4j.Jade4J;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;

@Getter
@Setter
@ConfigurationProperties("spring.jade4j")
public class Jade4jProperties extends AbstractTemplateViewResolverProperties {

    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    public static final String DEFAULT_SUFFIX = ".jade";

    private Boolean checkTemplateLocation = true;
    private Boolean caching = true;
    private Boolean prettyPrint = false;
    private Jade4J.Mode mode = Jade4J.Mode.HTML;
    private Integer resolverOrder = Ordered.LOWEST_PRECEDENCE - 50;

    protected Jade4jProperties() {
        super(DEFAULT_PREFIX, DEFAULT_SUFFIX);
    }
}