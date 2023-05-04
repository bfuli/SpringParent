package org.fuli.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"org.fuli.service"})
@Import(SpringMVCConfig.class)
public class SpringConfig {

}
