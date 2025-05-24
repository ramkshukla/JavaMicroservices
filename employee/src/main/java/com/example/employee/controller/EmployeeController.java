package com.example.employee.controller;



import com.example.employee.entity.Employee;
import com.example.employee.response.EmployeeResponse;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable("id") Integer id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping
    public java.util.List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}