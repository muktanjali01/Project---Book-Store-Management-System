package com.bookStoreManagementSystemApp.service;

import com.bookStoreManagementSystemApp.dto.CustomerDTO;
import com.bookStoreManagementSystemApp.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
}
