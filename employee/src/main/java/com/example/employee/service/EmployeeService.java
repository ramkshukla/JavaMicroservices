package com.example.employee.service;

import com.example.employee.client.AddressFeignClient;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.response.AddressResponse;
import com.example.employee.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AddressFeignClient addressFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeResponse getEmployeeById(Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            EmployeeResponse employeeResponse = mapper.map(employeeOptional.get(), EmployeeResponse.class);
            try {
//                AddressResponse addressResponse = restTemplate.getForObject(
//                        "http://address-service/address-service/api/address/{employeeId}",
//                        AddressResponse.class,
//                        employeeId
//                );
                AddressResponse addressResponse = addressFeignClient.getAddressByEmployeeId(employeeId);

                employeeResponse.setAddressResponse(addressResponse);
            } catch (HttpClientErrorException.NotFound e) {
                employeeResponse.setAddressResponse(null);
            }
            return employeeResponse;
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}