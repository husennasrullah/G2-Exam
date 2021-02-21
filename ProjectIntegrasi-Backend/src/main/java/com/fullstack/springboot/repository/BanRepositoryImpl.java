package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Ban;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("banRepository")
public class BanRepositoryImpl implements BanRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Ban> findAllBan() {
        return jdbcTemplate.query("select * from hargaBan",
                (rs, rowNum) ->
                        new Ban(
                                rs.getString("idBan"),
                                rs.getString("merkBan"),
                                rs.getString("jenisBan"),
                                rs.getDouble("hargaSatuan")
                        )
        );
    }

    @Override
    public List<Ban> findAllWithPaging(int page, int limit) {
        int numPages;
        numPages = jdbcTemplate.query("SELECT COUNT(*) as count FROM hargaBan",
                (rs, rowNum) -> rs.getInt("count")).get(0);
        // validate page
        if (page < 1) page = 1;
        if (page > numPages) page = numPages;

        int start = (page - 1) * limit;
        List<Ban> daftarBan =
                jdbcTemplate.query("SELECT * FROM hargaBan LIMIT " + start + "," + limit + ";",
                        (rs, rowNum) ->
                                new Ban(
                                        rs.getString("idBan"),
                                        rs.getString("merkBan"),
                                        rs.getString("jenisBan"),
                                        rs.getDouble("hargaSatuan")
                                )
                );
        return daftarBan;
    }

    @Override
    public void createBan(Ban ban) {
        UUID id = UUID.randomUUID();
        String idTire = "Tire-"+id;
        jdbcTemplate.update("INSERT INTO hargaBan VALUES (?,?,?,?)",
                //ban.getIdBan(),
                idTire,
                ban.getMerkBan(),
                ban.getJenisBan(),
                ban.getHargaSatuan()
        );
    }

    @Override
    public void updateBan(Ban ban) {
        jdbcTemplate.update("update hargaBan set merkBan=?, jenisBan=?, hargaSatuan=? where idBan=?",
                ban.getMerkBan(),
                ban.getJenisBan(),
                ban.getHargaSatuan(),
                ban.getIdBan()
        );
    }

    @Override
    public Ban findById(String idBan) {
        return jdbcTemplate.queryForObject("select * from hargaBan where idBan = ?",
                (rs, rowNum) ->
                        new Ban(
                                rs.getString("idBan"),
                                rs.getString("merkBan"),
                                rs.getString("jenisBan"),
                                rs.getDouble("hargaSatuan")
                        ), idBan
        );
    }

    @Override
    public List<Ban> findByName(String merkBan) {
        return jdbcTemplate.query("select * from hargaban where merkBan like ?",
                new Object[]{"%" + merkBan},
                (rs, rowNum) ->
                        (new Ban(
                                rs.getString("idBan"),
                                rs.getString("merkBan"),
                                rs.getString("jenisBan"),
                                rs.getDouble("hargaSatuan")
                        ))
        );
    }

    @Override
    public void deleteBanById(String idBan) {
        jdbcTemplate.update("delete from hargaBan where idBan = ?", idBan);
    }

    @Override
    public void deleteAllBan() {
        jdbcTemplate.update("delete  from hargaBan");

    }

    @Override
    public boolean isBanExist(Ban ban) {
        return false;
    }
}