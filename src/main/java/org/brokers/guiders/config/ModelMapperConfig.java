package org.brokers.guiders.config;


import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Mentoring, MentoringDetail>() {
            @Override
            protected void configure() {
                map().setWriter(source.getFollower().getName());
            }
        });
        return modelMapper;
    }

}
