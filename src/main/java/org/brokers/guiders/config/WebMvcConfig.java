package org.brokers.guiders.config;

import org.brokers.guiders.util.NaverLoginBO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.brokers.guiders")
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/resources/css/");
        registry.addResourceHandler("/js/**", "/resources/js/");
        registry.addResourceHandler("/img/**", "/resources/img/");
        registry.addResourceHandler("/font/**", "/resources/font/");
        registry.addResourceHandler("/editor/**", "/resources/editor/");
    }

    @Bean
    public NaverLoginBO naverLoginBO() {
        return new NaverLoginBO();
    }

}
