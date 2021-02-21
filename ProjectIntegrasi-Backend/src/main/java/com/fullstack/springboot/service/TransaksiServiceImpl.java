package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Transaksi;
import com.fullstack.springboot.model.TransaksiResponse;
import com.fullstack.springboot.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("transaksiService")
public class TransaksiServiceImpl implements TransaksiService{

    @Autowired
    TransaksiRepository transaksiRepository;

    @Override
    public List<Transaksi> findAll() {
        List<Transaksi> listTransaksi = transaksiRepository.findAll();
        return listTransaksi;
    }

    @Override
    public List<TransaksiResponse> findAllTransaksi() {
        List<TransaksiResponse> listTransaksi = transaksiRepository.findAllTransaksi();
        return listTransaksi;
    }

    @Override
    public TransaksiResponse findById(String idTransaksi) {
        return transaksiRepository.findById(idTransaksi);
    }

    @Override
    public void saveTransaksi(Transaksi transaksi) {
        synchronized (this) {
            transaksiRepository.saveTransaksi(transaksi);
        }
    }

    @Override
    public void updateTransaksi(Transaksi transaksi) {
        synchronized (this) {    //  Critical section synchronized
            transaksiRepository.updateTransaksi(transaksi);
        }
    }

    @Override
    public boolean isTransaksiExist(Transaksi transaksi) {
        return transaksiRepository.findById(transaksi.getIdTransaksi())!=null;
    }

    @Override
    public List<Transaksi> findAllWithPaging(int page, int limit) {
        return transaksiRepository.findAllWithPaging (page, limit);
    }
}
