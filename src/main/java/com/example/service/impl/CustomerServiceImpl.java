package com.example.service.impl;

import com.example.entity.Customer;
import com.example.entity.CustomerCategory;
import com.example.repository.CustomerRepository;
import com.example.repository.OrderDetailRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findOneByUsername(username);
        if (customer == null){
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }
        //en spring security los roles tienen nombre de GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        customer.getCustomerRoles().forEach(role->{
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new User(customer.getUsername(), customer.getPassword(), authorities);
        return userDetails;
    }

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findByCustomerCategory(CustomerCategory category) {
        return customerRepository.findByCustomerCategory(category);
    }

    @Override
    public Customer findOneByUsername(String username) {
        return customerRepository.findOneByUsername(username);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Long UserRole= new Long(2);

        customer.setState("CREATED");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer guardar = customerRepository.save(customer);
        customerRepository.assignRole(guardar.getId(),UserRole);
        return guardar;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = this.getCustomer(customer.getId());
        if (customerDB == null) {
            return null;
        }
        customerDB.setCustomerAge(customer.getCustomerAge());
        customerDB.setCustomerName(customer.getCustomerName());
        customerDB.setState("UPDATED");
        return customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = this.getCustomer(id);
        if (customerDB == null) {
            return null;
        }
        customerDB.setState("DELETED");
        return customerRepository.save(customerDB);
    }

    @Override
    @Transactional
    public void assignRole(Long customerId, Long roleId) {
        customerRepository.assignRole(customerId, roleId);
    }
}
