package com.salemnabeel.wikicoursesapp.security.service;

import com.salemnabeel.wikicoursesapp.security.model.Employee;
import com.salemnabeel.wikicoursesapp.security.model.EmployeeDetails;
import com.salemnabeel.wikicoursesapp.security.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Employee> employee = employeeRepository.findByUserName(userName);

        employee.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return employee.map(EmployeeDetails::new).get();
    }
}