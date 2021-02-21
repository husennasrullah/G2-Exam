package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Teknisi;

import java.util.List;

public interface TeknisiRepository {
    void createTeknisi(Teknisi teknisi);

    void updateTeknisi(Teknisi teknisi);

    List<Teknisi> findAllTeknisi();

    List<Teknisi> findAllWithPaging(int page, int limit);

    Teknisi findById(String idTeknisi);

    public List<Teknisi> findByName(String namaTeknisi);

    void deleteTeknisiById(String idTeknisi);

    void deleteAllCustomer();

    boolean isTeknisiExist(Teknisi teknisi);
}
