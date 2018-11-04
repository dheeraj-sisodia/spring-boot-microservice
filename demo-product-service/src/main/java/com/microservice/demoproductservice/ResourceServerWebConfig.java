package com.microservice.demoproductservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.microservice.demoproductservice" })
public class ResourceServerWebConfig implements WebMvcConfigurer {
    //
}
