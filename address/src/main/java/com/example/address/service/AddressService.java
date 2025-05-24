package com.example.address.service;

import com.example.address.entity.Address;
import com.example.address.model.AddressResponse;
import com.example.address.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressOpt = addressRepo.findByEmployeeId(employeeId);
        return addressOpt.map(address -> mapper.map(address, AddressResponse.class)).orElse(null);
    }
}