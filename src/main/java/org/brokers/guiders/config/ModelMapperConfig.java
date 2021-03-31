package org.brokers.guiders.config;


import org.brokers.guiders.web.mentoring.Mentoring;
import org.brokers.guiders.web.mentoring.payload.MentoringDetail;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<Date, String> dateToString = new AbstractConverter<>() {
            @Override
            protected String convert(Date source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                return sdf.format(source);
            }
        };

        Converter<LocalDateTime, String> localDateTimeToString = new AbstractConverter<>() {
            @Override
            protected String convert(LocalDateTime source) {
                return source.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
            }
        };

        modelMapper.addConverter(dateToString);
        modelMapper.addConverter(localDateTimeToString);

        modelMapper.addMappings(new PropertyMap<Mentoring, MentoringDetail>() {
            @Override
            protected void configure() {
                map().setWriter(source.getFollower().getName());
            }
        });
        return modelMapper;
    }

}
