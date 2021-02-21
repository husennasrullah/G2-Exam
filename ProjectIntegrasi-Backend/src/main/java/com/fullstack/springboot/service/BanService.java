package com.fullstack.springboot.service;

import com.fullstack.springboot.model.Ban;
import com.fullstack.springboot.model.Teknisi;

import java.util.List;

public interface BanService {

    List<Ban> findAllBan();

    List<Ban> findAllWithPaging(int page, int limit);

    void createBan(Ban ban);

    void updateBan(Ban ban);

    Ban findById(String idBan);

    Ban findByName(String merkBan);

    void deleteBanById(String idBan);

    void deleteAllBan();

    boolean isBanExist(Ban ban);
}
