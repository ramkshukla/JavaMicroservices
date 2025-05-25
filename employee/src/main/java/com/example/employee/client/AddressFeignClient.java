package com.example.employee.client;

import com.example.employee.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", path = "/address-service/api")
public interface AddressFeignClient {
    @GetMapping("/address/{employeeId}")
    AddressResponse getAddressByEmployeeId(@PathVariable("employeeId") Integer employeeId);
}
