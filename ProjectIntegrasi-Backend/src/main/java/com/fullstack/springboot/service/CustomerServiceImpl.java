package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Customer;
import com.fullstack.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customer = customerRepository.findAllCustomer();
        return customer;
    }

    @Override
    public List<Customer> findAllWithPaging(int page, int limit) {
        List<Customer> dataCustomer = customerRepository.findAllWithPaging(page, limit);
        return dataCustomer;
    }

    @Override
    public void createCustomer(Customer customer) {
        synchronized (this) {
            customerRepository.createCustomer(customer);
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        synchronized (this) {
            customerRepository.updateCustomer(customer);
        }
    }

    @Override
    public Customer findById(String idCustomer) {
        return customerRepository.findById(idCustomer);
    }

    @Override
    public Customer findByName(String namaCustomer) {
        return null; //customerRepository.findByName(namaCustomer).get(0);
    }

    @Override
    public void deleteCustomerById(String idCustomer) {
        synchronized (this){
            customerRepository.deleteCustomerById(idCustomer);
        }
    }

    @Override
    public boolean isCustomerExist(Customer customer) {
        return false;
        //return customerRepository.findByName(customer.getNamaCustomer()).size() !=0;
    }
}
