package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Jasa;
import com.fullstack.springboot.repository.JasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jasaService")
public class JasaServiceImpl implements JasaService{

    @Autowired
    JasaRepository jasaRepository;

    @Override
    public List<Jasa> findAllJasa() {
        List <Jasa> jasa = jasaRepository.findAllJasa();
        return jasa;
    }

    @Override
    public List<Jasa> findAllWithPaging(int page, int limit) {
        List<Jasa> jasa = jasaRepository.findAllWithPaging(page, limit);
        return jasa;
    }

    @Override
    public void createJasa(Jasa jasa) {
        synchronized (this){
            jasaRepository.createJasa(jasa);
        }
    }

    @Override
    public void updateJasa(Jasa jasa) {
        synchronized (this){
            jasaRepository.updateJasa(jasa);
        }
    }

    @Override
    public Jasa findById(String idJasa) {
        return jasaRepository.findById(idJasa);
    }

    @Override
    public Jasa findByName(String jenisJasa) {
        return jasaRepository.findByName(jenisJasa).get(0);
    }

    @Override
    public void deleteJasaById(String idJasa) {
        synchronized (this){
            jasaRepository.deleteJasaById(idJasa);
        }
    }

    @Override
    public void deleteAllJasa() {
        jasaRepository.deleteAllJasa();
    }

    @Override
    public boolean isJasaExist(Jasa jasa) {
        return false;
        //return teknisiRepository.findByName(teknisi.getNamaTeknisi()).size() !=0;
    }
}
