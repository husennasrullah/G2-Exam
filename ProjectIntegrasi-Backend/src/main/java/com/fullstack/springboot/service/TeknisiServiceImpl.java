package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Teknisi;
import com.fullstack.springboot.repository.TeknisiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("teknisiService")
public class TeknisiServiceImpl implements TeknisiService {

    @Autowired
    TeknisiRepository teknisiRepository;


    @Override
    public List<Teknisi> findAllWithPaging(int page, int limit) {
        List<Teknisi> teknisi = teknisiRepository.findAllWithPaging(page, limit);
        return teknisi;
    }

    @Override
    public void createTeknisi(Teknisi teknisi) {
        synchronized (this) {
            teknisiRepository.createTeknisi(teknisi);
        }
    }

    @Override
    public void updateTeknisi(Teknisi teknisi) {
        synchronized (this){
            teknisiRepository.updateTeknisi(teknisi);
        }
    }

    @Override
    public List<Teknisi> findAllTeknisi() {
        List<Teknisi> teknisi = teknisiRepository.findAllTeknisi();
        return teknisi;
    }

    @Override
    public Teknisi findById(String idTeknisi) {
        return teknisiRepository.findById(idTeknisi);
    }

    @Override
    public Teknisi findByName(String namaTeknisi) {
//        return teknisiRepository.findByName(namaTeknisi);
      return teknisiRepository.findByName(namaTeknisi).get(0);
    }

    @Override
    public void deleteTeknisiById(String idTeknisi) {
        synchronized (this){
            teknisiRepository.deleteTeknisiById(idTeknisi);
        }
    }

    @Override
    public void deleteAllCustomer() {
        teknisiRepository.deleteAllCustomer();
    }

    @Override
    public boolean isTeknisiExist(Teknisi teknisi) {
        return false;
//        return teknisiRepository.findByName(teknisi.getNamaTeknisi()).size() !=0;
    }
}
