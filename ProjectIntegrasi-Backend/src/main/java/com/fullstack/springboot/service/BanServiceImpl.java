package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Ban;
import com.fullstack.springboot.repository.BanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("banService")
public class BanServiceImpl implements  BanService{

    @Autowired
    BanRepository banRepository;

    @Override
    public List<Ban> findAllBan() {
        List <Ban> ban = banRepository.findAllBan();
        return ban;
    }

    @Override
    public List<Ban> findAllWithPaging(int page, int limit) {
        List<Ban> ban = banRepository.findAllWithPaging(page, limit);
        return ban;
    }

    @Override
    public void createBan(Ban ban) {
        synchronized (this){
            banRepository.createBan(ban);
        }
    }

    @Override
    public void updateBan(Ban ban) {
        synchronized (this){
            banRepository.updateBan(ban);
        }
    }

    @Override
    public Ban findById(String idBan) {
        return banRepository.findById(idBan);
    }

    @Override
    public Ban findByName(String merkBan) {
        return banRepository.findByName(merkBan).get(0);
    }

    @Override
    public void deleteBanById(String idBan) {
        synchronized (this){
            banRepository.deleteBanById(idBan);
        }
    }

    @Override
    public void deleteAllBan() {
        banRepository.deleteAllBan();
    }

    @Override
    public boolean isBanExist(Ban ban) {
        return false;
        //return teknisiRepository.findByName(teknisi.getNamaTeknisi()).size() !=0;
    }
}
