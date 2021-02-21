package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Ban;

import java.util.List;

public interface BanRepository {
    List<Ban> findAllBan();

    List<Ban> findAllWithPaging(int page, int limit);

    void createBan(Ban ban);

    void updateBan(Ban ban);

    Ban findById(String idBan);

    List<Ban> findByName(String merkBan);

    void deleteBanById(String idBan);

    void deleteAllBan();

    boolean isBanExist(Ban ban);
}
