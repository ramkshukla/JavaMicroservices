package com.example.address.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.address")
public class AddressConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}