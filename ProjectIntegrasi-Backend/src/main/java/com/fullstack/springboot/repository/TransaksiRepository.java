package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Transaksi;
import com.fullstack.springboot.model.TransaksiResponse;

import java.util.List;

public interface TransaksiRepository {
    public List<Transaksi> findAll ();

    public List<TransaksiResponse> findAllTransaksi();

    TransaksiResponse findById(String idTransaksi);

    void saveTransaksi(Transaksi transaksi);

    void updateTransaksi(Transaksi transaksi);

    public List<Transaksi> findAllWithPaging(int page, int limit);
}
