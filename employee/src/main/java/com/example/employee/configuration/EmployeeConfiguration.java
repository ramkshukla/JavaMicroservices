package com.example.employee.configuration;



import com.example.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfiguration {

    @Bean
    public EmployeeService employeeBean() {
        return new EmployeeService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
