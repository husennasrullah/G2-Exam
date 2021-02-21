package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Customer;
import com.fullstack.springboot.model.Teknisi;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    List<Customer> findAllWithPaging(int page, int limit);

    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findById(String idCustomer);

    Customer findByName(String namaCustomer);

    void deleteCustomerById(String idCustomer);

    boolean isCustomerExist(Customer customer);
}
