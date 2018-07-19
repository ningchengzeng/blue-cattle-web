package com.bluecattle.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jade")
@Getter
@Setter
public class JadeProperties {
    private String path = "/WEB-INF/views/";
    private String encoding = "UTF-8";
    private String suffix = ".jade";
}
