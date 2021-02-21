package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Teknisi;

import java.util.List;

public interface TeknisiService {
    List<Teknisi> findAllWithPaging(int page, int limit);

    void createTeknisi(Teknisi teknisi);

    void updateTeknisi(Teknisi teknisi);

    List<Teknisi> findAllTeknisi();

    Teknisi findById(String idTeknisi);

    Teknisi findByName(String namaTeknisi);

    void deleteTeknisiById(String idTeknisi);

    void deleteAllCustomer();

    boolean isTeknisiExist(Teknisi teknisi);
}
