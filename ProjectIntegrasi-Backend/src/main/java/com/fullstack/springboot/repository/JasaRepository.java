package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Jasa;

import java.util.List;

public interface JasaRepository {
    List<Jasa> findAllJasa();

    List<Jasa> findAllWithPaging(int page, int limit);

    void createJasa(Jasa jasa);

    void updateJasa(Jasa jasa);

    Jasa findById(String idJasa);

    List<Jasa> findByName(String jenisJasa);

    void deleteJasaById(String idJasa);

    void deleteAllJasa();

    boolean isJasaExist(Jasa jasa);
}
