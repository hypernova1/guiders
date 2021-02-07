package org.brokers.guiders.config;


import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.MentoringDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig extends ModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addMappings(new PropertyMap<Mentoring, MentoringDto.Response>() {
            @Override
            protected void configure() {
                map().setWriter(source.getFollower().getName());
            }
        });
        return modelMapper;
    }

}
