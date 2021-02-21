package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> findAllCustomer() {
        return jdbcTemplate.query("select * from customer",
                (rs, rowNum) ->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("alamat"),
                                rs.getLong("noTelepon")
                        )
        );
    }

    @Override
    public List<Customer> findAllWithPaging(int page, int limit) {
        int numPages;
        numPages = jdbcTemplate.query("SELECT COUNT(*) as count FROM customer",
                (rs, rowNum) -> rs.getInt("count")).get(0);
        // validate page
        if (page < 1) page = 1;
        if (page > numPages) page = numPages;

        int start = (page - 1) * limit;
        List<Customer> daftarCustomer =
                jdbcTemplate.query("SELECT * FROM customer LIMIT " + start + "," + limit + ";",
                        (rs, rowNum) ->
                                new Customer(
                                        rs.getString("idCustomer"),
                                        rs.getString("namaCustomer"),
                                        rs.getString("alamat"),
                                        rs.getLong("noTelepon")
                                )
                );
        return daftarCustomer;
    }

    @Override
    public void createCustomer(Customer customer) {
        UUID id = UUID.randomUUID();
        String idCus = "Cust-"+id;
        jdbcTemplate.update("INSERT INTO customer VALUES (?,?,?,?)",
                //customer.getIdCustomer(),
                idCus,
                customer.getNamaCustomer(),
                customer.getAlamat(),
                customer.getNoTelepon()
        );
    }

    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update("update customer set namaCustomer=?, alamat=?, noTelepon=?  where idCustomer=?",
                customer.getNamaCustomer(),
                customer.getAlamat(),
                customer.getNoTelepon(),
                customer.getIdCustomer()
        );
    }

    @Override
    public Customer findById(String idCustomer) {
        return jdbcTemplate.queryForObject("select * from customer where idCustomer = ?",
                (rs, rowNum) ->
                        new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("alamat"),
                                rs.getLong("noTelepon")
                        ), idCustomer
        );
    }

    @Override
    public List<Customer> findByName(String namaCustomer) {
        return jdbcTemplate.query("select * from customer where namaCustomer like ?",
                new Object[]{"%" + namaCustomer},
                (rs, rowNum) ->
                        (new Customer(
                                rs.getString("idCustomer"),
                                rs.getString("namaCustomer"),
                                rs.getString("alamat"),
                                rs.getLong("noTelepon")
                        ))
        );
    }

    @Override
    public void deleteCustomerById(String idCustomer) {
        jdbcTemplate.update("delete from customer where idCustomer = ?", idCustomer);
    }

    @Override
    public boolean isCustomerExist(Customer customer) {
        return false;
    }
}
