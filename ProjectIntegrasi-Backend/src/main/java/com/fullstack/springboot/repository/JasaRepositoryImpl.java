package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Jasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("jasaRepository")
public class JasaRepositoryImpl implements JasaRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Jasa> findAllJasa() {
        return jdbcTemplate.query("select * from jasa",
                (rs, rowNum) ->
                        new Jasa(
                                rs.getString("idJasa"),
                                rs.getString("jenisJasa"),
                                rs.getDouble("hargaSatuan"),
                                rs.getInt("lamaPengerjaan")
                        )
        );
    }

    @Override
    public List<Jasa> findAllWithPaging(int halaman, int limit) {
        int noHal;
        noHal = jdbcTemplate.query("SELECT COUNT(*) as count FROM jasa",
                (rs, rowNum) -> rs.getInt("count")).get(0);

        // validasi halaman
        if (halaman < 1) halaman = 1;
        if (halaman > noHal) halaman = noHal;

        int mulai = (halaman - 1) * limit;
        List<Jasa> daftarJasa =
                jdbcTemplate.query("SELECT * FROM jasa LIMIT " + mulai + "," + limit + ";",
                        (rs, rowNum) ->
                                new Jasa(
                                        rs.getString("idJasa"),
                                        rs.getString("jenisJasa"),
                                        rs.getDouble("hargaSatuan"),
                                        rs.getInt("lamaPengerjaan")
                                )
                );
        return daftarJasa;
    }

    @Override
    public void createJasa(Jasa jasa) {
        UUID id = UUID.randomUUID();
        String idServ = "Serv-"+id;
        jdbcTemplate.update("INSERT INTO jasa VALUES (?,?,?,?)",
                //jasa.getIdJasa(),
                idServ,
                jasa.getJenisJasa(),
                jasa.getHargaSatuan(),
                jasa.getLamaPengerjaan()
        );

    }

    @Override
    public void updateJasa(Jasa jasa) {
        jdbcTemplate.update("update jasa set jenisJasa=?, hargaSatuan=?, lamaPengerjaan=? where idJasa=?",
                jasa.getJenisJasa(),
                jasa.getHargaSatuan(),
                jasa.getLamaPengerjaan(),
                jasa.getIdJasa()
        );

    }

    @Override
    public Jasa findById(String idJasa) {
        return jdbcTemplate.queryForObject("select * from jasa where idJasa = ?",
                (rs, rowNum) ->
                        new Jasa(
                                rs.getString("idJasa"),
                                rs.getString("jenisJasa"),
                                rs.getDouble("hargaSatuan"),
                                rs.getInt("lamaPengerjaan")
                        ), idJasa
        );
    }

    @Override
    public List<Jasa> findByName(String jenisJasa) {
        return jdbcTemplate.query("select * from jasa where jenisJasa like ?",
                new Object[]{"%" + jenisJasa},
                (rs, rowNum) ->
                        (new Jasa(
                                rs.getString("idJasa"),
                                rs.getString("jenisJasa"),
                                rs.getDouble("hargaSatuan"),
                                rs.getInt("lamaPengerjaan")
                        ))
        );
    }

    @Override
    public void deleteJasaById(String idJasa) {
        jdbcTemplate.update("delete from jasa where idJasa = ?", idJasa);

    }

    @Override
    public void deleteAllJasa() {
        jdbcTemplate.update("delete from jasa");

    }

    @Override
    public boolean isJasaExist(Jasa jasa) {
        return false;
    }
}
