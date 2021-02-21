package com.fullstack.springboot.controller;


import com.fullstack.springboot.model.Customer;
import com.fullstack.springboot.model.Teknisi;
import com.fullstack.springboot.service.CustomerService;
import com.fullstack.springboot.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CustomerController {
    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    // end-point untuk mengambil seluruh data
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomer() {
        List<Customer> dataCustomer = customerService.findAllCustomer();
        if (dataCustomer.isEmpty()) {
            return new ResponseEntity<>(dataCustomer, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataCustomer, HttpStatus.OK);
    }

    // end-point untuk mengambil seluruh data dengan paging
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/paging/", method = RequestMethod.GET)
    public ResponseEntity<?>getCustomerWithPaging(@RequestParam int page, @RequestParam int limit){
        List<Customer> daftarTeknisi = customerService.findAllWithPaging(page, limit);
        if(daftarTeknisi.isEmpty()){
            return new ResponseEntity<>(daftarTeknisi,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(daftarTeknisi,HttpStatus.OK);
        }
    }

    // end-point untuk mengambil single data customer
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/{idCustomer}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable("idCustomer") String idCustomer) {
        logger.info("mengambil customer dengan id {}", idCustomer);
        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            logger.error("teknisi dengan id {} tidak ditemukan.", idCustomer);
            return new ResponseEntity<>(new CustomErrorType("customer dengan id " + idCustomer + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // end-point untuk mengambil single data customer (by name)
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/nama/{namaCustomer}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByName(@PathVariable("namaCustomer") String namaCustomer) {
        logger.info("mengambil data Customer dengan nama {}", namaCustomer);
        Customer customer= customerService.findByName(namaCustomer);
        if (customer == null) {
            logger.error("Customer dengan nama {} tidak ditemukan.", namaCustomer);
            return new ResponseEntity<>(new CustomErrorType("Customer dengan nama" + namaCustomer+ " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        logger.info("membuat data teknisi : {}", customer);

        if (customerService.isCustomerExist(customer)) {
            logger.error("tidak bisa memuat data, teknisi dengan nama {} sudah ada", customer.getNamaCustomer());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Customer with name " +
                    customer.getNamaCustomer() + " already exist."), HttpStatus.CONFLICT);
        }
        customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    // end-point untuk update data customer
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/{idCustomer}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeknisi(@PathVariable("idCustomer") String idCustomer, @RequestBody Customer customer) {
        logger.info("update data teknisi dengan id {}", idCustomer);

        Customer dataCustomer = customerService.findById(idCustomer);
        if (dataCustomer == null) {
            logger.error("tidak bisa update. customer dengan id {} tidak ditemukan.", idCustomer);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa update. customer dengan id " + idCustomer +
                    " tidak ditemukan."),
                    HttpStatus.NOT_FOUND);
        }

        dataCustomer.setNamaCustomer(customer.getNamaCustomer());
        dataCustomer.setAlamat(customer.getAlamat());
        dataCustomer.setNoTelepon(customer.getNoTelepon());

        customerService.updateCustomer(dataCustomer);

        return new ResponseEntity<>(dataCustomer, HttpStatus.OK);
    }

    // end-point untuk delete data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/customer/{idCustomer}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("idCustomer") String idCustomer) {
        logger.info("memuat dan menghapus data customer dengan id {}", idCustomer);

        Customer customer = customerService.findById(idCustomer);
        if (customer == null) {
            logger.error("tidak bisa menghapus!! data customer dengan id {} tidak ditemukan.", idCustomer);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa menghapus data, teknisi dengan id " + idCustomer + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }

        customerService.deleteCustomerById(idCustomer);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}
