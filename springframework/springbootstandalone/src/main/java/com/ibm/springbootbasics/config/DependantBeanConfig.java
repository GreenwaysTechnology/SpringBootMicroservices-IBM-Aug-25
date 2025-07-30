package com.ibm.springbootbasics.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependantBeanConfig {
    @Bean
    public OptionalBean optionalBean() {
        return new OptionalBean();
    }

    @Bean
    @ConditionalOnBean(OptionalBean.class)
    //Create this bean(DependantBean only if OptionalBean is available,if not dont create)
    public DependantBean dependantBean(){
        return new DependantBean();
    }
}
