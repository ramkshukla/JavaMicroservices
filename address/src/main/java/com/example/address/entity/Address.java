package com.example.address.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String state;

    @Column(name = "employee_id")
    private int employeeId;

    // getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
}