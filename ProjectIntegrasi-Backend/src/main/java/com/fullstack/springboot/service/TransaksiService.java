package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Transaksi;
import com.fullstack.springboot.model.TransaksiResponse;

import java.util.List;

public interface TransaksiService {
    public List<Transaksi> findAll ();

    public List<TransaksiResponse> findAllTransaksi();

    TransaksiResponse findById(String idTransaksi);

    void saveTransaksi(Transaksi transaksi);

    void updateTransaksi(Transaksi transaksi);

    boolean isTransaksiExist(Transaksi transaksi);

    public List<Transaksi> findAllWithPaging(int page, int limit);

}
