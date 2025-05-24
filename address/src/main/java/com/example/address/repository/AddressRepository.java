package com.example.address.repository;

import java.util.Optional;

import com.example.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Optional<Address> findByEmployeeId(int employeeId);
}