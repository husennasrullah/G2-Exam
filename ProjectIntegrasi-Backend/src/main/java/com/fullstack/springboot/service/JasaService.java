package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Jasa;

import java.util.List;

public interface JasaService {
    List<Jasa> findAllJasa();

    List<Jasa> findAllWithPaging(int page, int limit);

    void createJasa(Jasa jasa);

    void updateJasa(Jasa jasa);

    Jasa findById(String idJasa);

    Jasa findByName(String jenisJasa);

    void deleteJasaById(String idJasa);

    void deleteAllJasa();

    boolean isJasaExist(Jasa jasa);
}
